package chapter02.lesson07;

import java.util.List;
import java.util.function.Predicate;

public class LambdaClosed {

    public static void main(String[] args) {

        List<Post> posts = BaseStreamApp.createPosts();
        // Predicate - <T> 안에 들어가는 매개변수 타입으로 true, false 를 반환 받음 (boolean 의 개념)
        Predicate<Post> isClosed = post -> post.isClosed();

        for (Post post : posts) {
            if (isClosed.test(post)) {
                System.out.println(post.getTitle());
            }
        }
    }

}
