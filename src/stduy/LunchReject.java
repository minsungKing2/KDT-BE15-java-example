package stduy;

public class LunchReject {
    public void takeMenu(String menu) {
        if (menu == null || menu.equals("")) {
            throw new IllegalArgumentException("empty-menu");
        }
        System.out.println("menu = " + menu);
    }

    public static void main(String[] args) {
        LunchReject app = new LunchReject();
        try {
            app.takeMenu("");
        } catch (IllegalArgumentException ex) {
            System.out.println("reject = " + ex.getMessage());
        }
        app.takeMenu("pork");
    }

}

