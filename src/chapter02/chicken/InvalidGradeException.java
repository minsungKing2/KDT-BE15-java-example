package chapter02.chicken;

public class InvalidGradeException extends IllegalArgumentException {
    public InvalidGradeException(String grade) {
        super("존재하지 않는 등급입니다 : " + grade);
    }
}
