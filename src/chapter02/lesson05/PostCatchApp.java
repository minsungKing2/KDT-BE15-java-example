package chapter02.lesson05;

public class PostCatchApp {

    public static void main(String[] args) {
        PostRepository repository = new MemoryPostRepository();
        PostService service = new PostService(repository);

        service.register("closed", "no class");
        try {
            service.register("", "ignored");
        } catch (EmptyTitleException ex) {
            System.out.println("reject = " + ex.getMessage());
        }
        service.register("exam", "bring id");
        service.close("p1");
        service.close("n9");
        service.printAll();
    }

}
