package chapter02.lesson03;

public class Question {
    private String text;
    private final Tutor tutor;

    public Question(String text, Tutor tutor) {
        this.text = text;
        this.tutor = tutor;
    }

    public void print() {
        System.out.println("text = " + text);
        System.out.println("tutor = " + tutor);
    }
}
