package chapter02.lesson07;

import java.util.ArrayList;
import java.util.List;

public class BaseStreamApp {
    public static void main(String[] args) {
        List<Post> posts = createPosts();
        for (Post post : posts) {
            post.print();
        }
    }

    public static List<Post> createPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("점심 김치찌개", "12시 출발", false));
        posts.add(new Post("Java 스터디", "람다 복습", true));
        posts.add(new NoticePost("시험 안내", "금요일 10시", true, "3강의실"));
        posts.add(new Post("저녁 파스타", "6시 출발", false));
        return posts;
    }
}