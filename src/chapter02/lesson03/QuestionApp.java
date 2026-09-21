package chapter02.lesson03;

public class QuestionApp {

    public static void main(String[] args) {

        Tutor tutor = new Tutor("kim");
        Question question = new Question("exam time", tutor);

        question.print();
    }

}
