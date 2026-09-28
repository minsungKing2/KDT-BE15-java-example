package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePostJson {

    public static void main(String[] args) throws IOException {

        Post post = new Post("closed", "no class"); // 객체 생성

        String json = toJson(post); // 객체 -> Json 형식 변환

        Files.createDirectories(Path.of("data")); // 파일 생성
        Path path = Path.of("data", "post.json"); // 경로 설정

        Files.writeString(path, json, StandardCharsets.UTF_8); // 쓰기
        String loaded = Files.readString(path, StandardCharsets.UTF_8); // 읽기

        System.out.println("json = " + loaded);
    }

    static String toJson(Post post) {
        return "{\"title\":\"" + post.getTitle()
                + "\",\"body\":\"" + post.getBody() + "\"}";
    }

}
