package chapter02.lesson07;

import java.util.List;

public class StreamSearch {

    public static void main(String[] args) {

        List<Post> posts = BaseStreamApp.createPosts();

        // return 이 stream 이면, 중간 연산.
        // return 이 int, long, boolean 등과 같은 타입이면, 종단 연산.
        boolean hasExam = posts.stream()
                .anyMatch(post -> post.getTitle().contains("시험"));

        long closedCount = posts.stream()
                .filter(Post::isClosed)
                .count();

        String firstDinner = posts.stream()
                .filter(post -> post.getTitle().contains("저녁"))
                .map(post -> post.getTitle())
                .findFirst() // Optional<T> 타입은 null 값이 들어올 수 있음.
                .orElse("저녁 모임이 없다.");// orElse - 이것도 저것도 아니면.

        System.out.println("시험 글 존재: " + hasExam);
        System.out.println("마감 글 수: " + closedCount);
        System.out.println("첫 저녁 글: " + firstDinner);

    }

}
