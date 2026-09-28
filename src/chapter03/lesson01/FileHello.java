package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHello {

    public static void main(String[] args) throws IOException {

        Path dir = Path.of("data"); // Path - 경로 설정, 경로 설정은 루트부터 시작한다.

        Files.createDirectories(dir); // createDirectories - 폴더 생성. 폴더가 있어도 예외를 터트리지 않는다.

        Path path = Path.of("data", "hello.txt");

        Files.writeString(path, "kimbap\n", StandardCharsets.UTF_8); // 쓰기

        String text = Files.readString(path, StandardCharsets.UTF_8); // 읽기

        System.out.println("text = " + text.stripTrailing()); // stripTrailing() - 문자열의 끝(오른쪽)에 있는 모든 공백을 제거하는 메서드
        System.out.println("exists = " + Files.exists(path)); // exists() - path 가 존재하면 true, 존재하지 않으면 false
        System.out.println("path = " + path.toAbsolutePath()); // toAbsolutePath() - path 가 가진 절대경로
    }

}
