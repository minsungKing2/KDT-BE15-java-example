package chapter02.chicken;

public class MainTest {

    public static void main(String[] args) {

        Chicken chicken = new Chicken(1, "후라이드", 18000);
        System.out.println(chicken.getId() + " / " + chicken.getName() + " / " + chicken.getPrice());

        DiscountPolicy policy = new VipDiscountPolicy();
        System.out.println(policy.discount(20000)); // 20000 - 2000 = 18000
    }

}
