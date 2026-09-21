package chapter02.lesson03;

public class PinnedDemo {

    public static void main(String[] args) {

        PinnedPost pin = new PinnedPost("exam", "bring id");
        pin.changeTitle("quiz");
        pin.pin();
        pin.changeTitle("closed");
        pin.print();
    }

}
