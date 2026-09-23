package chapter02.lesson07;

public class NoticePost extends Post {
    private final String place;

    public NoticePost(String title, String body, boolean closed, String place) {
        super(title, body, closed);
        this.place = place;
    }

    public String getPlace() { return place; }

    @Override
    public void print() {
        super.print();
        System.out.println("장소: " + place);
    }
}