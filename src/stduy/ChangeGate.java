package stduy;

import java.util.Scanner;

public class ChangeGate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

/*
        int charge = 500;

        if (charge < 0) {
            System.out.println("short!");
        } else {
            System.out.println("charge = " + charge);
        }
*/

/*
        System.out.print("score? ");
        int score = sc.nextInt();
        char grade;

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("grade = " + grade);
*/

        String a = "kimbap";
        String b = "kimbap";

        if (a.equals(b)) {
            System.out.println("true");
        } else System.out.println("false");

    }
}
