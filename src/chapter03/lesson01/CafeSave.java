package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CafeSave {

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Path.of("data"));

        Path path = Path.of("data", "cafe.json");

        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("pork", "6000won"));
        list.add(new Post("water", "1000won"));

        Files.writeString(path, toArrayJson(list), StandardCharsets.UTF_8);
        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));
        System.out.println("exists = " + Files.exists(path));

    }

    static String toArrayJson(ArrayList<Post> posts) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < posts.size(); i++) {
            if (i > 0) {
                json.append(", ");
            }
            json.append(toJson(posts.get(i)));
        }
        json.append("]");
        return json.toString();
    }

    static String toJson(Post post) {
        return "{\"title\" : \"" + post.getTitle()
                + "\", \"body\" : \"" + post.getBody() + "\"}";
    }

}
