package chapter02.lesson05;

public class BaseLayerApp {
    public static void main(String[] args) {
        PostRepository repository = new MemoryPostRepository();
        PostService service = new PostService(repository);
        service.register("closed", "body");
        service.printAll();
    }
}