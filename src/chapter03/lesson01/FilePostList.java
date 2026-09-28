package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePostList {

    public static void main(String[] args) throws IOException {

        Post a = new Post("closed", "no class");
        Post b = new Post("exam", "bring id");

        String json = "[" + toJson(a) + "," + toJson(b) + "]";

        Files.createDirectories(Path.of("data"));
        Path path = Path.of("data", "posts.json");

        Files.writeString(path, json, StandardCharsets.UTF_8);
        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));
    }

    static String toJson(Post post) {
        return "{\"title\":\"" + post.getTitle()
                + "\",\"body\":\"" + post.getBody() + "\"}";
    }

}
