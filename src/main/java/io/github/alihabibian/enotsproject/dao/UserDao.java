package io.github.alihabibian.enotsproject.dao;

import io.github.alihabibian.enotsproject.user.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean registerUser(UserDetails userDetails) {
        boolean isRegistered = false;
        //language=SQL
        String query = "INSERT INTO `e_notes`.`user` (name, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDetails.getName());
            ps.setString(2, userDetails.getEmail());
            ps.setString(3, userDetails.getPassword());

            int result = ps.executeUpdate();

            if (result == 1)
                isRegistered = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegistered;
    }

    public boolean loginUser(UserDetails userDetails) {
        boolean isLogin = false;
        String query = "SELECT * FROM user WHERE email=? AND password=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDetails.getEmail());
            ps.setString(2, userDetails.getPassword());

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next())
                isLogin = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isLogin;
    }
}
