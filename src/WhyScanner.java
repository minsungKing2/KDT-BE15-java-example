import java.util.Scanner;

public class WhyScanner {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("ready!");
        String line = input.nextLine();

        int val = input.nextInt();

        System.out.println(line);
        System.out.println("val = " + val);
    }
}
