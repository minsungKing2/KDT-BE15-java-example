package stduy;

import java.util.Scanner;

public class ParsePrice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

/*
        System.out.println("price?");
        String raw = sc.nextLine();
        int price = Integer.parseInt(raw);

        System.out.println("price=" + price);

        int price2 = Integer.parseInt(sc.nextLine());

        System.out.println("price2 = " + price2);
*/

/*
        int total = 5500;
        String text = String.valueOf(5500);

        int kimbap = 4500;
        double kimbap2 = kimbap;

        System.out.println("kimbap2 = " + kimbap2);
*/

        double rating = 4.9;
        int stars = (int) rating;
        System.out.println("stars = " + stars);

        int a = 30;
        double b = a;
        System.out.println("b = " + b);
    }
}