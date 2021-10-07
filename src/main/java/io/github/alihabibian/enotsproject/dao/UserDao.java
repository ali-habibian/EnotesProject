package io.github.alihabibian.enotsproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_notes", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
