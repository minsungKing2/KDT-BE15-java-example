package chapter02.lesson05;

public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    public void create(String title, String body) {
        System.out.println("ctrl = create");
        service.register(title, body);
    }

    public void list() {
        System.out.println("ctrl = list");
        service.printAll();
    }

    public void close(String id) {
        System.out.println("ctrl = close");
        service.close(id);
    }


}
