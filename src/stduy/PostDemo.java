package stduy;

public class PostDemo {

    public static void main(String[] args) {

        Post post = new Post();
        post.body = "본문1";
        post.title = "제목1";

        Post post1 = new Post();
        post1.body = "본문2";
        post1.title = "제목2";

        Post post2 = new Post();

        post.print();
        post1.print();

        System.out.println(post.plusTitle());
        post.printArg("arg print test");
        post.addBody(" 크림");

        post.addTitle("1", "2");
        post.addTitle("1", 200);

        post.test("good!");


    }

}
