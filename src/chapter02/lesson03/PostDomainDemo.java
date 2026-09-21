package chapter02.lesson03;

public class PostDomainDemo {

    public static void main(String[] args) {
        Post post = new Post("closed", "title");

        post.changeTitle("");

        post.changeTitle("exam");

        post.close();

        post.changeTitle("quiz");

        post.print();
    }
}
