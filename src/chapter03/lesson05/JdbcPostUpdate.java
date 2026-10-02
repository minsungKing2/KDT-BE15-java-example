package chapter03.lesson05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPostUpdate {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {

        String sql = "UPDATE jdbc_post SET body = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "edited java");
            ps.setInt(2, 4);

            // executeUpdate() - 변경된 행의 개수를 반환
            int n = ps.executeUpdate();

            System.out.println("update " + n);
        }
    }

}
