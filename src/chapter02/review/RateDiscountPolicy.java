package chapter02.review;

public class RateDiscountPolicy implements DiscountPolicy {
    // 상수
    private static final int RATE = 10;

    @Override
    public int discount(int originalPrice) {
        // 원가에서 10% 를 할인한 값을 반환 (소수점 버림, 정수 연산)
        return originalPrice * (100 - RATE) / 100;
    }
}
