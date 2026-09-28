package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;

public class RollJson {

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Path.of("data"));

        Path empty = Path.of("data", "empty.json"); // Path - 경로 설정

        Files.writeString(empty, toArrayJson(new ArrayList<>()), StandardCharsets.UTF_8);
        System.out.println("empty = " + Files.readString(empty, StandardCharsets.UTF_8));

        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("closed", "no class"));
        list.add(new Post("exam", "bring id"));
        list.add(new Post("kimbap", "sold out"));

        // 객체 -> JSON 형태로 바꾸는 것을 직렬화라고 함.
        // JSON -> 객체 형태로 바꾸는 것을 역직렬화라고 함.
        Path path = Path.of("data", "roll.json");
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
