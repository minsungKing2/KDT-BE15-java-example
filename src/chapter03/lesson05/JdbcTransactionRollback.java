package chapter03.lesson05;

import java.sql.*;

/**
 * 트랜잭션과 rollback 예제.
 * 두 건을 INSERT 한 뒤 commit 하지 않고 rollback 해서, DB에는 둘 다 남지 않게 한다.
 * 기본(auto-commit)은 SQL 한 번이 끝날 때마다 바로 저장된다.
 * setAutoCommit(false) 이후의 변경은 commit() 해야 확정되고, rollback() 하면 취소된다.
 */
public class JdbcTransactionRollback {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 이 연결에서 이후 SQL은 자동 저장되지 않는다. 같은 연결 안에서만 묶인다.
            conn.setAutoCommit(false); // AutoCommit false

            try{
                String sql = "INSERT INTO tray (item) VALUES (?)";
                try(PreparedStatement ps = conn.prepareStatement(sql)){
                    // 같은 PreparedStatement의 ? 값만 바꿔 두 번 실행한다.
                    ps.setString(1, "java-first");
                    ps.executeUpdate();
                    ps.setString(1, "java-second");
                    ps.executeUpdate();
                }
                // commit()을 호출하지 않는다. rollback 하면 위 두 INSERT가 모두 사라진다.
                conn.rollback();
                System.out.println("rolled back");
            } catch (SQLException e) {
                // INSERT 도중 오류가 나도, 그때까지 넣은 내용을 취소한 뒤 예외를 다시 던진다.
                conn.rollback();
                throw e;
            } finally{
                // 성공이든 실패든, 이 연결을 원래대로(SQL마다 자동 저장) 되돌린다.
                conn.setAutoCommit(true);
            }

            // rollback이 됐는지 확인. java- 로 시작하는 item이 몇 개인지.
            // LIKE 'java-%' 에서 % 는 '그 뒤에 어떤 글자가 와도 된다'는 뜻.
            try(PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) FROM tray WHERE item LIKE ?"
            )) {
                ps.setString(1, "java-%");
                try (ResultSet rs = ps.executeQuery()){
                    rs.next();
                    // 이 프로그램이 넣은 두 건은 취소됐으므로, 이전에 남은 행이 없다면 0.
                    System.out.println("count = " + rs.getInt(1));
                }
            }
        }

    }

}
