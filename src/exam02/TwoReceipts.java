/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 3
 */
package exam02;

public class TwoReceipts {

    public static void main(String[] args) {

        int kimbap = 4500;
        int water = 1000;
        int count = 2;
        int mix = kimbap + water * count;
        int pack = (kimbap + water) * count;
        int sum = kimbap + water;

        System.out.println("mix = " + mix);
        System.out.println("pack = " + pack);
        System.out.println("wrong = " + kimbap + water);
        System.out.println("sum = " + sum);
        //mix 와 pack 이 다른 이유: 연산자 우선순위 차이
    }

}
