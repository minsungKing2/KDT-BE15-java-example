package chapter02.lesson03;

public class PostOopDemo {

    public static void main(String[] args) {
        /*

        Post post = new Post();
        post.title = "closed";
        post.body = "no class";

        post.setTitle("closed");
        post.setBody("no class");

        post.print();
        */

        Post post = new Post("closed", "no class");
        Post post1 = new Post("closed1", "no class1");
        post.print();
        post1.print();

        System.out.println(Post.getCount()); // static 변수는 Class 로 접근한다.

        NoticePost noticePost = new NoticePost("t1~", "t2", "t3");
        noticePost.print();

    }

}
