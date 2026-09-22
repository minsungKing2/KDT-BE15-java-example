package chapter02.chicken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final OrderRepository orderRepository;
    private final ChickenRepository chickenRepository;
    private final CustomerRepository customerRepository;

    private final Map<String, DiscountPolicy> policyMap = new HashMap<>();

    public OrderService(OrderRepository orderRepository, ChickenRepository chickenRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.chickenRepository = chickenRepository;
        this.customerRepository = customerRepository;

        policyMap.put("NORMAL", new NormalDiscountPolicy());
        policyMap.put("VIP", new VipDiscountPolicy());
        policyMap.put("NEWBIE", new NewbieDiscountPolicy());
    }

    public Order order(int orderId, int customerId, int chickenId) {
        Customer customer = customerRepository.findById(customerId);
        Chicken chicken = chickenRepository.findById(chickenId);

        DiscountPolicy discountPolicy = policyMap.get(customer.getGrade());

        if (discountPolicy == null) {
            throw new InvalidGradeException(customer.getGrade());
        }

        int originalPrice = chicken.getPrice();
        int finalPrice = discountPolicy.discount(originalPrice);

        Order order = new Order(orderId, customer.getId(), chicken.getId(), originalPrice, finalPrice);
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
