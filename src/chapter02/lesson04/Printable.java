package chapter02.lesson04;

public interface Printable {
    int a = 10; // 상수

    void print();

    default void printA() {
        System.out.println("a = " + a);
    }
}
