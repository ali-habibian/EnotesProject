package io.github.alihabibian.enotsproject.dao;

import io.github.alihabibian.enotsproject.model.Post;
import io.github.alihabibian.enotsproject.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDao {
    private Connection conn;

    public PostDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addNote(String title, String content, int uid) {
        boolean isAdded = false;
        String query = "INSERT INTO post (title,content,uid) VALUES (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, uid);
            int result = ps.executeUpdate();

            if (result == 1)
                isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
}
