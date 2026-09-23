package chapter02.lesson07;

import chapter02.chicken.ChickenNotFoundException;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> hit = Optional.of("김밥");
        System.out.println("hit.get() = " + hit.get());

        Optional<String> empty = Optional.empty();

        System.out.println("hit=" + hit.orElseGet(() -> "품절")); // orElseGet() - 값이 있으면 값을 출력하고, 없으면 "품절" 을 찍는다.
        System.out.println("miss=" + empty.orElseGet(() -> "품절"));

        hit.ifPresent(value -> System.out.println("선택=" + value));

        // 값이 없다면, 예외를 던진다.
        hit.orElseThrow(
                () -> new ChickenNotFoundException(1)
        );

    }

}



