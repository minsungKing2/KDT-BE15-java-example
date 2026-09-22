package chapter02.lesson05;

public class LayerApp {

    public static void main(String[] args) {
        MemoryPostRepository repository = new MemoryPostRepository();
        PostService service = new PostService(repository);
        PostController controller = new PostController(service);

        controller.create("closed", "body");

        try {
            controller.create("", "ignored");
        } catch (EmptyTitleException ex) {
            System.out.println("reject = " + ex.getMessage());
        }

        controller.create("exam", "bring id");
        controller.close("p1");
        controller.list();
    }

}
