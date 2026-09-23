package chapter02.lesson06;

public class Post {
    private static int sequence = 0;

    private final String id;
    private final String title;
    private final String body;
    private boolean closed;

    public Post(String title, String body) {
        sequence++;
        this.id = "p" + sequence;
        this.title = title;
        this.body = body;
    }

    public Post(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
    }

    public void print() {
        System.out.println("id=" + id);
        System.out.println("title=" + title);
        System.out.println("body=" + body);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Post)) {
            return false;
        }
        Post that = (Post) other;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}