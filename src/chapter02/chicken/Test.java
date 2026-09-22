package chapter02.chicken;

public class Test {

    public void forLoop(int n) {
        good(n);
    }

    private static void good(int n) {
        good1(n);
    }

    // ctrl + alt + m - 단축키
    private static void good1(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
        }
    }
}
