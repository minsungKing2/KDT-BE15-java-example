package chapter03.lesson05;

import java.sql.*;

// JDBC 연결 코드
public class JdbcPing {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);

             PreparedStatement ps = conn.prepareStatement("SELECT 1");

             ResultSet rs = ps.executeQuery()) {
            rs.next(); // 커서 이동이라고 이해하자. next()

            // ResultSet 에서는 index가 1부터 시작한다.
            System.out.println("db ping : " + rs.getInt(1));
            // 에러 트래킹은 스택을 생각해서 아래부터 위로 즉, 역방향으로 생각한다!
        }

    }

}