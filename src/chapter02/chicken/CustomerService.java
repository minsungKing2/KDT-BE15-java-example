package chapter02.chicken;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(int id, String name, String grade) {
        /* boolean valid = grade.equals("NORMAL") || grade.equals("VIP") || grade.equals("NEWBIE"); 도 가능
        if (!valid) {
            throw new InvalidGradeException(grade);
        } 도 가능 */

        if (grade.equals("NORMAL") || grade.equals("VIP") || grade.equals("NEWBIE")) {
            Customer customer = new Customer(id, name, grade);
            customerRepository.save(customer);
        } else throw new InvalidGradeException(grade);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id);
    }

}
