/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 3
 */
package exam03;

import java.util.Scanner;

public class NoticeCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("title? ");
        String title = sc.nextLine();

        System.out.println("body? ");
        String body = sc.nextLine();

        System.out.println("saved title = " + title);
        System.out.println("saved body = " + body);
        System.out.println("card = " + title + " / " + body);
    }
}
