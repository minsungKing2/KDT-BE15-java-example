package chapter02.lesson07;

import java.util.List;

public class FlatMapDemo {

    public static void main(String[] args) {

        List<List<String>> tagRows = List.of(
                List.of("java", "stream"),
                List.of("stream", "lambda")
        );

        List<String> tags = tagRows.stream()
                .flatMap(List::stream) // 하나로 펴다. -> 이중 리스트를 하나로 바꿈.
                .distinct() // distinct() - 중복 제거
                .sorted()
                .toList();

        System.out.println(tags);

    }

}
