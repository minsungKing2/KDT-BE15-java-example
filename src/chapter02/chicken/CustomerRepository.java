package chapter02.chicken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {

    // private final 꼭 쓰기!
    private final Map<Integer, Customer> store = new HashMap<>();

    // 저장
    public void save(Customer customer) {
        store.put(customer.getId(), customer);
    }

    // 조건부 조회 (읽기)
    public Customer findById(int id) {
        if (store.get(id) == null) {
            throw new CustomerNotFoundException(id);
        }
        return store.get(id);
    }

    // 전체 조회 (읽기)
    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }
}
