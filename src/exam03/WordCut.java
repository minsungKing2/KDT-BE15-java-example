/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 4
 */
package exam03;

import java.util.Scanner;

public class WordCut {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("menu? ");
        String word = sc.next();
        String rest = sc.nextLine();

        System.out.println("word = " + word);
        System.out.println("rest = " + rest);
    }
}
