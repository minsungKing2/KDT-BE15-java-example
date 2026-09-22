package chapter02.chicken;
/**
 * [Main] 애플리케이션의 시작점.
 * <p>
 * 이 클래스의 역할:
 * - 객체들을 "직접 조립"한다 (의존성 주입, DI).
 * - 초기 시드 데이터를 넣는다.
 * - Controller를 실행한다.
 * <p>
 * → 이렇게 조립 코드를 Main에 몰아두면, 나중에 다른 환경(테스트 등)에서
 * 다른 Repository 구현체를 끼워 넣기 쉬워진다.
 */
public class Main {

    public static void main(String[] args) {

        // 1) Repository 인스턴스 생성 (메모리 저장소)
        ChickenRepository chickenRepository = new ChickenRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        // 2) Service 인스턴스 생성 (Repository를 주입)
        ChickenService chickenService = new ChickenService(chickenRepository);
        CustomerService customerService = new CustomerService(customerRepository);
        OrderService orderService = new OrderService(
                orderRepository, chickenRepository, customerRepository
        );

        // 3) 초기 데이터 (시드)
        chickenService.registerChicken(1, "후라이드", 18000);
        chickenService.registerChicken(2, "양념치킨", 20000);
        chickenService.registerChicken(3, "뿌링클", 23000);
        chickenService.registerChicken(4, "황금올리브", 25000);

        customerService.registerCustomer(1, "홍길동", "VIP");
        customerService.registerCustomer(2, "김철수", "NORMAL");
        customerService.registerCustomer(3, "이영희", "NEWBIE");

        // 4) Controller 실행
        ChickenController controller = new ChickenController(
                chickenService, customerService, orderService
        );
        controller.run();
    }
}