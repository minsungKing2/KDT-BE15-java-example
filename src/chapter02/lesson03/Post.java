package chapter02.lesson03;

import java.util.Objects;

public class Post {

    private static int count = 0; // static - 공유되는 변수

    private String title;
    private String body;
    private final String id; // final - 한 번 선언되면, 변하지 않는다. (불변)
    private boolean closed; // 글을 수정할 수 있는지에 대한 여부, boolean default 값은 false

    public void print() {
        System.out.println("title = " + title);
        System.out.println("body = " + body);
    }

    public String getId() {
        return this.id;
    }

    public void changeTitle(String next) {
        if (this.closed) {
            System.out.println("reject = closed");
            return;
        }
        if (next == null || next.isEmpty()) {
            System.out.println("reject = empty-title;");
            return;
        }
        this.title = next;
    }

    public void close() {
        this.closed = true;

    }

    public boolean isClosed() {
        return closed;
    }

    public Post(String title, String body) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("empty-title");
        }
        count += 1;
        this.id = "p" + count;
        this.title = title;
        this.body = body;
        this.closed = false;
    }

    public Post(String id, String title, String body) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("empty-title");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("empty-id");
        }
        this.id = id;
        this.title = title;
        this.body = body;
        count += 1;
    }


    public static int getCount() {
        return count;
    }

    /*
    public Post(int title, String body) {

    }
    */

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // id 가 같은지 판단 여부
    @Override
    public boolean equals(Object o) {
/*      if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
*/
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        Post that = (Post) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
//        return Objects.hashCode(id);
        return id.hashCode();
    }
}
