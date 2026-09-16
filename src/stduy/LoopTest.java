package stduy;

public class LoopTest {

    public static void main(String[] args) {

/*
        for (int i = 1; i < 6; i++) {
            System.out.println("반복 " + i);
        }
*/
/*
        int n = 1;
        while (true) {

        }
*/

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }

    }

}
