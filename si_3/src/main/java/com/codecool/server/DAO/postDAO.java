package com.codecool.server.DAO;

import com.codecool.server.ConnectionBuilder.ConnectionBuilder;
import com.codecool.server.Post.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class postDAO implements DAO {

    private static final String
            SELECT_QUERY =  "SELECT message, name, email, date\n" +
            "FROM posts;\n";

    public List<Post> getAllPosts() {
        try {
            List<Post> posts = new ArrayList<>();

            Connection connection = ConnectionBuilder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                posts.add(getPostData(resultSet));
            }
            Collections.reverse(posts);
            return posts;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertPost(Post post) {
        String
                insertQuery =
                        "INSERT INTO posts (message, name, email)\n" +
                        "VALUES (?, ?, ?);\n";

        try {
            Connection connection = ConnectionBuilder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, post.message);
            preparedStatement.setString(2, post.name);
            preparedStatement.setString(3, post.email);

            int updateResult = preparedStatement.executeUpdate();

            if(updateResult == 1) {
                return true;
            }

            preparedStatement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Post getPostData(ResultSet resultSet) throws SQLException{
        String message = resultSet.getString("message");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String date = resultSet.getString("date");

        date = date.split("\\.")[0];
        Post student = new Post(message, name, email, date);

        return student;
    }
}
