package chapter02.lesson04;

public class SnackRun {

    public static void main(String[] args) {

        CafeItem[] items = {
                new KimbapItem(),
                new WaterItem(),
                new CookieItem()
        };

        Tray tray = new Tray(items);

        tray.printAll();
        System.out.println("total = " + tray.total());
    }

}
