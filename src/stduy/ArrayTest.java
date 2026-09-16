package stduy;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
/*

        String[] titles2 = new String[3];

        String[] titles = {"closed", "exam", "holiday"};

        String[] titles3 = new String[3];

        System.out.println("titles3 = " + titles3);
        int[] ints = new int[5];

        System.out.println(ints[0]);
*/
/*
        int[] titles = {1, 2, 3};
        int[] titles2 = titles;

        System.out.println("titles = " + titles);
        System.out.println("titles2 = " + titles2);

        titles2[0] = 99;

        System.out.println(titles[0]);

        Arrays.copyOfRange()
*/

/*
        int a;
        int b = 1;

        int[][] ints = new int[3][2];

        for (int i = 0; i < ints.length; i++) {
            System.out.println("i = " + ints[i]);
        }
*/

        int[] ints = new int[3];

        for (int i = 0; i < ints.length; i++) {
            System.out.println(i + "=" + ints[i]);
        }

        for (int idx : ints) {
            System.out.println("idx = " + idx);
        }

        int[][] ints2 = new int[3][2];

        for (int i = 0; i < ints2.length; i++) {
            System.out.println(i + "=" + ints2[i]);
        }



    }
}
