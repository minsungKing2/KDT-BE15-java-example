package chapter02.lesson07;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingDemo {
    public static void main(String[] args) {
        /*
        posts.add(new Post("점심", "김밥", false));
        posts.add(new Post("시험", "신분증 준비", true));
        posts.add(new NoticePost("점심", "제육볶음", false, "학생식당"));
        posts.add(new Post("휴강", "보강 일정 확인", true));
         */
        List<Post> posts = AdvancedBaseApp.createPosts();

        Map<String, List<Post>> byTitle = posts.stream()
                .collect(Collectors.groupingBy(post -> post.getTitle()));

        Map<String, Long> counts = posts.stream()
                .collect(Collectors.groupingBy(post -> post.getTitle(), Collectors.counting()));

        String joined = posts.stream()
                .map(post -> post.getTitle())
                .collect(Collectors.joining(", "));

        System.out.println("점심 묶음 크기: " + byTitle.get("점심").size());
        System.out.println("점심 개수: " + counts.get("점심"));
        System.out.println("제목: " + joined);
    }
}
