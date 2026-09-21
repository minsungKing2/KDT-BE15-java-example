package stduy;

public class LunchThrow {

    public void takeMenu(String menu) throws IllegalArgumentException {
        if (menu == null || menu.equals("")) {
//            System.out.println("empty-menu");
            throw new IllegalArgumentException("empty-menu"); // IllegalArgumentException - 메서드에 맞이 않는 인자가 들어옴.
        }
        System.out.println("menu=" + menu);
    }

    public void takeName(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("");
        }
    }


    public static void main(String[] args) {

        LunchThrow lunchThrow = new LunchThrow();

        lunchThrow.takeMenu("");
        lunchThrow.takeMenu("pork");
    }

}
