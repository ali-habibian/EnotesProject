package io.github.alihabibian.enotsproject.dao;

import io.github.alihabibian.enotsproject.model.Post;
import io.github.alihabibian.enotsproject.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Post> getData(int userId) {
        List<Post> list = new ArrayList<>();
        Post post = null;
        //language=MySQL
        String query = "SELECT * FROM e_notes.post WHERE uid=? ORDER BY id DESC";
        try (
                PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getInt(1));
                post.setTitle(resultSet.getString(2));
                post.setContent(resultSet.getString(3));
                post.setpDate(resultSet.getTimestamp(4));
                list.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
