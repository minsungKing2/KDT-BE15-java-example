package chapter02.lesson03;

public class PostWithAuthor {
    private final String title;
    private final Author author;

    public PostWithAuthor(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public void print() {
        System.out.println("title = " + title);
        System.out.println("author = " + author.getName());
    }
}
