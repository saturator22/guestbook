package com.codecool.server.DAO;
import com.codecool.server.Post.Post;
import java.util.List;

public interface DAO {

    List<Post> getAllPosts();
    void insertPost();

}
