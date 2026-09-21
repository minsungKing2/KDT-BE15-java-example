package chapter02.lesson04;

import java.util.ArrayList;

public class PolyBoard {

    public static void printAll(ArrayList<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            posts.get(i).print();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("exam", "bring id"));
        posts.add(new NoticePost("closed", "no class", "cafeteria"));

        PolyBoard.printAll(posts);

        System.out.println("count = " + Post.getCount());
    }

}
