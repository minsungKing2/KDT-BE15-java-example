package chapter03.lesson05;

import java.sql.*;

// 2026-10-12 JDBC 실습 문제
// 통합 미션 1. JDBC로 조회 -> 조건부 삽입 -> 수정 -> 재조회 연결하기
public class JdbcPostWorkflow {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {

        // Connection conn = DriverManager.getConnection(URL, USER, PASS)
        // JDBC DriverManager를 이용하여 Connection 해준 것.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            // 1. 글을 쓸 회원. id가 가장 작은 1명. 없으면 여기서 종료.
            int memberId;
            String sql = "SELECT id FROM jdbc_member ORDER BY id LIMIT 1;";

            // PreparedStatement는 Java JDBC에서 SQL 쿼리문을 미리 컴파일하고 실행하기 위해 사용하는 인터페이스
            // executeQuery()는 JDBC에서 데이터베이스의 SELECT 문을 실행하여 결과를 조회할 때 사용하는 메서드
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("no jdbc_member");
                    return;
                }
                memberId = rs.getInt("id");
                System.out.println("1. memberId = " + memberId);
            }

            // 2. 제목 jdbc-flow 가 이미 있는지. 없으면 postId는 0으로 남긴다.
            int postId = 0;

            try(PreparedStatement ps = conn.prepareStatement(
                    "SELECT id FROM jdbc_post WHERE title = ? ORDER BY id;"
            )){
                ps.setString(1, "jdbc-flow");

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        postId = rs.getInt("id");
                        System.out.println("2. postId = " + postId);
                    }
                }
            }

            // 3. 행이 없을 때만 본문이 draft인 게시글을 한 번 추가합니다.
            if (postId == 0) {
                // 없으면 title = "jdbc-flow", body = "draft" -> jdbc_post에 insert
                try(PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO jdbc_post(member_id, title, body) VALUES(?, ?, ?);"
                )) {
                    ps.setInt(1, memberId);
                    ps.setString(2, "jdbc-flow");
                    ps.setString(3, "draft");
                    System.out.println("3번 inserted = " + ps.executeUpdate());
                }

                // 4. jdbc-flow의 id를 다시 조회합니다.
                try(PreparedStatement ps = conn.prepareStatement(
                        "SELECT id FROM jdbc_post WHERE title = ? ORDER BY id;"
                )) {
                    ps.setString(1, "jdbc-flow");
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            postId = rs.getInt("id");
                            System.out.println("4번 postId = " + postId);
                        }
                    }
                }
            }

            // try() - try-with-resources문. 외부 db랑 연결해주는 용도로 사용함.

            // 5. 해당 id 한 행의 본문을 verified로 수정합니다.
            try(PreparedStatement ps = conn.prepareStatement(
                    "UPDATE jdbc_post SET body = ? WHERE id = ?;"
            )) {
                ps.setString(1, "verified");
                ps.setInt(2, postId);
                System.out.println("5. updated = " + ps.executeUpdate());
            }

            // 6. 최종 id, title, body를 출력합니다.
            try(PreparedStatement ps = conn.prepareStatement(
                    "SELECT id, title, body FROM jdbc_post WHERE id = ?;"
            )) {
                ps.setInt(1, postId);
                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) {
                        // columnLabel은 열의 이름
                        System.out.println("6. " + rs.getInt("id") + ", "
                                + rs.getString("title") + ", "
                                + rs.getString("body"));
                    }
                }
            }
            }

        }

    }
