package chapter02.lesson05;

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    // register - 등록하다
    public void register(String title, String body) {
        if (title == null || title.isBlank()) {
            throw new EmptyTitleException();
        }
        repository.save(new Post(title, body));
        System.out.println("saved=" + title);
    }

    public void printAll() {
        for (Post post : repository.findAll()) {
            post.print();
            System.out.println("==========");
        }
    }

    public void close(String id) {
        for (Post post : repository.findAll()) {
            if (post.getId().equals(id)) {
                post.close();
                System.out.println("closed = " + id);
                return;
            }
        }
        System.out.println("missing = " + id);
    }
}
