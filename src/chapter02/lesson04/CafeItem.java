package chapter02.lesson04;

// abstract - 추상화, 추상 클래스
public abstract class CafeItem {

    // 추상 메서드
    public abstract int price();

    public void printWon() {
        System.out.println("won = " + price());
    }

}
