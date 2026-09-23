package chapter02.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExamPredicate {

    public static void main(String[] args) {
        List<Post> posts = BaseStreamApp.createPosts();

        Predicate<Post> containsExam = post -> post.getTitle().contains("시험");

        for (Post post : posts) {
            if (containsExam.test(post)) {
                System.out.println("post = " + post.getTitle());
            }
        }
    }

}
