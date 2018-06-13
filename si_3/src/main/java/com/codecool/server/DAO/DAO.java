package com.codecool.server.DAO;
import com.codecool.server.Post.Post;
import java.util.List;

public interface DAO {

    List<Post> getAllPosts();
    boolean insertPost(Post post);

}
