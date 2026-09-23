package chapter02.lesson06;

import java.util.ArrayList;
import java.util.List;

public class BaseCollectionApp {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("p1", "closed", "no class"));
        posts.add(new Post("p2", "exam", "bring id"));

        System.out.println("size=" + posts.size());
        System.out.println("first=" + posts.get(0).getTitle());
    }
}