package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SplitJson {

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Path.of("data"));

        Path path = Path.of("data", "pair.json");

        String json = "[" + toJson(new Post("closed", "no class")) + ", " + toJson(new Post("exam", "bring id")) + "]";

        Files.writeString(path, json, StandardCharsets.UTF_8);

        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));

        Path path2 = Path.of("data", "one.json");

        String json2 = toJson(new Post("closed", "no class"));

        Files.writeString(path2, json2, StandardCharsets.UTF_8);

        System.out.println("json = " + Files.readString(path2, StandardCharsets.UTF_8));
    }

    static String toJson(Post post) {
        return "{\"title\":\"" + post.getTitle()
                + "\",\"body\":\"" + post.getBody() + "\"}";
    }
}
