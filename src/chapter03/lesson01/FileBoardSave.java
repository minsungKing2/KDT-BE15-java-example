package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileBoardSave {

    public static void main(String[] args) throws IOException {

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("closed", "no class"));
        posts.add(new Post("exam", "bring id"));
        posts.add(new Post("kimbap", "sold out"));

        String json = toArrayJson(posts);

        Files.createDirectories(Path.of("data"));
        Path path = Path.of("data", "board.json");
        Files.writeString(path, json, StandardCharsets.UTF_8);

        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));
        System.out.println("exists = " + Files.exists(Path.of("data", "board.json")));
    }

    static String toArrayJson(ArrayList<Post> posts) {
        String json = "[";
        for (int i = 0; i < posts.size(); i++) {
            if (i > 0) {
                json += ", ";
            }
            json += toJson(posts.get(i));
        }
        json = json + "]";
        return json;
    }

    static String toJson(Post post) {
        return "{\"title\" : \"" + post.getTitle()
                + "\", \"body\" : \"" + post.getBody() + "\"}";
    }

}
