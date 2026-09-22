package chapter02.lesson04;

public class CafeMenuApp {

    public static void main(String[] args) {

        /*
        CafeItem[] items = new CafeItem[2];
        items[0] = new KimbapItem();
        items[1] = new WaterItem();
         */

        CafeItem[] items = {
                new KimbapItem(),
                new WaterItem()
        };

        for (CafeItem item : items) {
            item.printWon();
        }

    }
}
