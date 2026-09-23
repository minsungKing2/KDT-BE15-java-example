package chapter02.lesson07;

import java.util.List;

public class ClosedTitles {

    public static void main(String[] args) {
        List<Post> posts = BaseStreamApp.createPosts();

        posts.stream()
                //.filter(Post::isClosed); 도 가능
                // .map(Post::getTitle()) 도 가능. .map() 해주면 Post 타입을 String 타입으로 맵핑해줌.
                .filter(post -> post.isClosed())
                .map(post -> post.getTitle())
                .toList();
    }

}
