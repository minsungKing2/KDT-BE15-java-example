package chapter02.chicken;

public class CustomerNotFoundException extends IllegalArgumentException {
    public CustomerNotFoundException(int id) {
        super("존재하지 않는 고객 ID입니다 : " + id);
    }

}
