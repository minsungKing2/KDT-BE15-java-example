package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TwiceWrite {

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Path.of("data")); // 패키지 생성

        Path path = Path.of("data", "tray.txt"); // 경로 설정 및 파일 생성

        Files.writeString(path, "kimbap", StandardCharsets.UTF_8); // 쓰기
        System.out.println("text = " + Files.readString(path, StandardCharsets.UTF_8).stripTrailing()); // 읽기

        Files.writeString(path, "cookie", StandardCharsets.UTF_8); // 쓰기 -> 덮어쓰기 됨.
        System.out.println("text = " + Files.readString(path, StandardCharsets.UTF_8).stripTrailing()); // 읽기

        System.out.println("missing = " + Files.exists(Path.of("data", "try-missing.txt"))); // 파일 존재 유무
    }

}
