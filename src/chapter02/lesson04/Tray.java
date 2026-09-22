package chapter02.lesson04;

public class Tray {

    private final CafeItem[] items;

    public Tray(CafeItem[] items) {
        this.items = items;
    }

    public void printAll() {
        for (CafeItem item : items) {
            item.printWon();
        }
    }

    public int total() {
        int sum = 0;
        for (CafeItem item : items) {
            sum += item.price();
        }
        return sum;
    }

}
