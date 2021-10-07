package io.github.alihabibian.enotsproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_notes", "root", "");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
