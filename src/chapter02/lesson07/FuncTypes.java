package chapter02.lesson07;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncTypes {

    public static void main(String[] args) {

        Predicate<String> isExam = text -> text.equals("시험");
        Function<String, Integer> length = text -> text.length();
        Consumer<String> print = text -> System.out.println(text);
        Supplier<String> fallback = () -> "없음"; // Supplier 은 입력 값이 없으므로, () -> 로 대체함.

        System.out.println("조건 = " + isExam.test("시험"));
        System.out.println("길이 = " + length.apply("Java"));
        print.accept("출력");
        System.out.println("공급 = " + fallback.get());
    }

}
