/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 추가 문제 1
 */
package exam03;

import java.util.Scanner;

public class OrderCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int kimbap = 4500;
        int water = 1000;
        int total = kimbap + water;

        System.out.println("nick? ");
        String nick = sc.nextLine();

        System.out.println("menu? ");
        String menu = sc.nextLine();

        System.out.println("note? ");
        String note = sc.nextLine();

        System.out.println("nick = " + nick);
        System.out.println("menu = " + menu);
        System.out.println("note = " + note);
        System.out.println("kimbap = " + kimbap);
        System.out.println("water = " + water);
        System.out.println("total = " + total);

        System.out.println("slip = " + nick + "/" + menu + "/" + total);
    }
}
