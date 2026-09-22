package chapter02.lesson04;

public class LinePrintApp {

    public static void main(String[] args) {

        LinePrinter postPrinter = new LinePrinter(new Post("exam", "no class"));
        LinePrinter slipPrinter = new LinePrinter(new LunchSlip());

        postPrinter.run();
        slipPrinter.run();
    }

}
