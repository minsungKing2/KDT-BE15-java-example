package chapter03.lesson05;

import java.sql.*;

public class JdbcPostList {

    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {
        String sql = "SELECT id, title FROM jdbc_post ORDER BY id";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    System.out.println("id = " + id + ", title = " + title);
                }
            } // rs 종료
        } // db 연결 종료
    }

}
