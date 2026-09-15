/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 1
 */
package exam03;

import java.util.Scanner;

public class NameTag {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("name? ");

        String name = sc.nextLine();
        System.out.println("hello = " + name);
    }
}
