/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 2
 */
package exam03;

import java.util.Scanner;

public class CafePickup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nickname? ");
        String name = sc.nextLine() + " ";

        System.out.println("menu? ");
        String menu = sc.nextLine() + " ";

        System.out.println("place? ");
        String place = sc.nextLine() + " ";

        System.out.println("pickup = " + name + menu + place);
    }

}
