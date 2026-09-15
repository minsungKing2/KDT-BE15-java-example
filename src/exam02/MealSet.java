/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 2
 */
package exam02;

public class MealSet {

    public static void main(String[] args) {

        int pork = 6000;
        int count = 2;
        int rice = 1000;
        int total = pork * count + rice;
        boolean soldOut = false;
        char set = 'B';

        System.out.println("pork = " + pork);
        System.out.println("count = " + count);
        System.out.println("rice = " + rice);
        System.out.println("total = " + total);
        System.out.println("soldOut = " + soldOut);
        System.out.println("set = " + set);
    }
}
