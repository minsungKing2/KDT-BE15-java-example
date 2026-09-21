package chapter02.lesson04;

public class NoticePost extends Post {
    private final String place;

    public NoticePost(String title, String body, String place) {
        super(title, body);
        this.place = place;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("place=" + place);
    }
}