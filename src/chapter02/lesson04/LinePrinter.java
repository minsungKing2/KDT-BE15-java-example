package chapter02.lesson04;

public class LinePrinter {

    private final Printable printable;

    public LinePrinter(Printable printable) {
        this.printable = printable;
    }

    public void run() {
        printable.print();
    }
}
