package chapter02.lesson05;

import java.util.ArrayList;

public class MemoryPostRepository implements PostRepository {
    private final ArrayList<Post> posts = new ArrayList<>();

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public ArrayList<Post> findAll() {
        return new ArrayList<>(posts);
    }
}
