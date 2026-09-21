package chapter02.lesson04;

public class Post {
    private static int count = 0;
    private final String title;
    private final String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        count = count + 1;
    }

    public static int getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void print() {
        System.out.println("title=" + title);
        System.out.println("body=" + body);
    }
}
