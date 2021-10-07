package io.github.alihabibian.enotsproject.dao;

import io.github.alihabibian.enotsproject.user.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addUser(UserDetails userDetails) {
        boolean isAdded = false;
        //language=SQL
        String query = "INSERT INTO `e_notes`.`user` (name, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDetails.getName());
            ps.setString(2, userDetails.getEmail());
            ps.setString(3, userDetails.getPassword());

            int result = ps.executeUpdate();

            if (result == 1)
                isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
}
