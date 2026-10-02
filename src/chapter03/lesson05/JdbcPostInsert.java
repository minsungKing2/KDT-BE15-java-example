package chapter03.lesson05;

import java.sql.*;

public class JdbcPostInsert {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {
        // 조회와 INSERT가 같은 연결을 쓴다. 연결은 바깥 try 하나에서만 연다.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            int memberId;
            String findSql = "SELECT id FROM jdbc_member ORDER BY id LIMIT 1";
            try (PreparedStatement find = conn.prepareStatement(findSql);
                 ResultSet rs = find.executeQuery()) {

                if (!rs.next()) {
                    System.out.println("no jdbc_member");
                    return;
                }
                memberId = rs.getInt("id");
            }

            String sql = "INSERT INTO jdbc_post (member_id, title, body) VALUES (?, ?, ?);";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, memberId);
                ps.setString(2, "jdbc");
                ps.setString(3, "from java");

                // Read 제외 executeUpdate()로 한다. executeUpdate() 반환 값은 int 즉, 영향을 받은 행의 개수 반환한다.
                int n = ps.executeUpdate();

                System.out.println("inserted " + n);
                System.out.println(ps);
            }
        }


    }

}
