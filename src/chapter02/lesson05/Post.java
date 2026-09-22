package chapter02.lesson05;

public class Post {
    private static int count = 0;
    private final String id;
    private final String body;
    private String title;
    private boolean closed;

    public Post(String title, String body) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("empty-title");
        }
        count++;
        this.id = "p" + count;
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

    public void changeTitle(String next) {
        if (closed) {
            System.out.println("reject=closed");
            return;
        }
        if (next == null || next.isBlank()) {
            System.out.println("reject=empty-title");
            return;
        }
        title = next;
    }

    public void print() {
        System.out.println("title=" + title);
        System.out.println("body=" + body);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Post that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}