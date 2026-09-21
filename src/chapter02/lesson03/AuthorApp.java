package chapter02.lesson03;

public class AuthorApp {
    public static void main(String[] args) {
        Author writer = new Author("kim");
        PostWithAuthor post = new PostWithAuthor("closed", writer);
        post.print();
    }
}
