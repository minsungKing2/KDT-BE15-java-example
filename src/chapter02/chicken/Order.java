package chapter02.chicken;

public class Order {

    private final int orderId;
    private final int customerId;
    private final int chickenId;
    private final int originalPrice;
    private final int finalPrice;

    public Order(int orderId, int customerId, int chickenId, int originalPrice, int finalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.chickenId = chickenId;
        this.originalPrice = originalPrice;
        this.finalPrice = finalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getChickenId() {
        return chickenId;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}
