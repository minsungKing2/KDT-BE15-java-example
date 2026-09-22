package chapter02.lesson05;

import java.util.ArrayList;

public interface PostRepository {

    void save(Post post);
    ArrayList<Post> findAll();

}
