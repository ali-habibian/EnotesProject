package io.github.alihabibian.enotsproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            try {
//                For mysql
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_notes", "root", "");

                // For postgresql
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://ec2-23-23-164-251.compute-1.amazonaws.com:5432/df4q0mvvm9d3hd?sslmode=require",
                        "kakwiasmqhsoro", "245b28c84adfcd661efe6d64d6c71e130a9f30f117e70ba6bd2c8c3322b56d8c");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
