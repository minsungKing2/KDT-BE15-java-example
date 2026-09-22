package chapter02.chicken;

public interface DiscountPolicy {
    /**
     * @param price 원가
     * @return 할인이 적영된 최종 금액
     */

    int discount(int price);
}
