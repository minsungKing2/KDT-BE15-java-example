package chapter02.lesson07;

public class Post {
    private static int sequence = 1;

    private final String id;
    private final String title;
    private final String body;
    private boolean closed;

    public Post(String title, String body, boolean closed) {
        this.id = "p" + sequence++;
        this.title = title;
        this.body = body;
        this.closed = closed;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public boolean isClosed() { return closed; }
    public void close() { closed = true; }

    public void print() {
        System.out.println(id + " | " + title + " | " + (closed ? "마감" : "모집 중"));
    }
}