package chapter02.lesson07;

import java.util.ArrayList;
import java.util.List;

public class AdvancedBaseApp {
    public static List<Post> createPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("점심", "김밥", false));
        posts.add(new Post("시험", "신분증 준비", true));
        posts.add(new NoticePost("점심", "제육볶음", false, "학생식당"));
        posts.add(new Post("휴강", "보강 일정 확인", true));
        return posts;
    }

    public static void main(String[] args) {
        createPosts().forEach(Post::print);
    }
}
