package chapter02.lesson06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SafeRemove {

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("closed", "no class"));
        posts.add(new Post("exam", "bring id"));
        posts.add(new Post("closed", "makeup"));

        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getTitle().equals("closed")) {
                iterator.remove();
            }
        }
        System.out.println("left = " + posts.size());
        System.out.println("title = " + posts.get(0).getTitle());

    }

}
