package chapter02.lesson07;

import java.util.List;
import java.util.function.Predicate;

public class StreamClosed {

    public static void main(String[] args) {

        List<Post> posts = BaseStreamApp.createPosts();

        // Stream 예제 - 중간 연산, 종단 연산
        posts.stream()
                .filter(post -> post.isClosed()) // .filter - 중간 연산 -> post.isClosed() 가 true 인 것만 가져옴.
                .forEach(post -> System.out.println("post.getTitle() = " + post.getTitle())); // .forEach - 종단 연산 -> 필터링 된 값들을 출력함.

        List<Post> a = posts.stream()
                .filter(post -> post.isClosed())
                .filter(post -> post.getTitle().contains("시험"))
                .toList();
        System.out.println("a = " + a);
    }

}
