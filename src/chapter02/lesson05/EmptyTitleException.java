package chapter02.lesson05;

public class EmptyTitleException extends IllegalArgumentException {
    public EmptyTitleException() {
        // IllegalArgumentException("empty-title")
        super("empty-title");

    }
}
