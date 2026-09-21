package chapter02.lesson03;

public class Author {
    private final String name; // final - 상수 개념은 아님(불변). final 과 static final 의 차이
    private static final double PI = 3.14; // static final - 상수

    public Author(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
