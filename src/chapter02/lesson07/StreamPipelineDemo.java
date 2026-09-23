package chapter02.lesson07;

import java.util.List;

public class StreamPipelineDemo {
    public static void main(String[] args) {
        List<String> titles = List.of("closed", "exam", "closed", "quiz");
        List<String> top = titles.stream()
                .filter(t -> t.startsWith("c") || t.startsWith("e"))
                .map(String::toUpperCase) // 소문자 -> 대문자
                .distinct() // 중복 제거
                .sorted() // 정렬
                .limit(2) // 맨 앞 2개만 남김
                .toList(); // 리스트로 변경
        boolean allShort = titles.stream()
                .allMatch(t -> t.length() <= 6);
        System.out.println("top=" + top);
        System.out.println("allShort=" + allShort);
    }
}
