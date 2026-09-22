package chapter02.chicken;

public class NewbieDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(int price) {
        return (int) (price - (price * 0.2));
    }
}
