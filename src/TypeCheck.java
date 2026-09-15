public class TypeCheck {
    public static void main(String[] args) {

        int price = 4500; // 원 단위 정수
        double rating = 4.5; // 점이 있는 점수
        boolean soldOut = false; // true 또는 false만
        char seat = 'A'; // 글자 하나
        String menu = "kimbap"; // 글자 여러 개, 기본 타입 아님

        System.out.println("price=" + price);
        System.out.println("rating=" + rating);
        System.out.println("soldOut=" + soldOut);
        System.out.println("seat=" + seat);
        System.out.println("menu=" + menu);

        int integer_max = Integer.MAX_VALUE;

        System.out.println("integer_max = " + integer_max);
    }
}

