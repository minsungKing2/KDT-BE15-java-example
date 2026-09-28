package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class OverWriteJson {

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Path.of("data"));

        Path path = Path.of("data", "price.json");

        Files.writeString(path, toJson(new Post("menu", "rice")), StandardCharsets.UTF_8);

        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));

        Files.writeString(path, toJson(new Post("soup", "hot")), StandardCharsets.UTF_8);

        System.out.println("json = " + Files.readString(path, StandardCharsets.UTF_8));

        System.out.println("kept = " + Files.exists(Path.of("data", "post.json")));

    }

    static String toJson(Post post) {
        return "{\"title\":\"" + post.getTitle()
                + "\",\"body\":\"" + post.getBody() + "\"}";
    }

}
