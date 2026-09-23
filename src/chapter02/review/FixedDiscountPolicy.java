package chapter02.review;

public class FixedDiscountPolicy implements DiscountPolicy {
    // 상수 static final
    private static final int FIXED_AMOUNT = 1000;

    @Override
    public int discount(int originalPrice) {
        // 자바에서 제공하는 기본 라이브러리 Math 를 통해 수학 연산에 도움을 주는 메서드를 쓸 수 있다.
        // 1. 원가에서 1000원을 뺀 값을 반환
        // 2. 단, 결과가 0 미만이면 0 을 반환 -> Math.max(인자1, 인자2) 둘 중 큰 값을 반환한다.
        return Math.max(0, originalPrice - FIXED_AMOUNT);
    }
}
