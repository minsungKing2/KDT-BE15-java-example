package chapter02.chicken;

import java.util.List;
import java.util.Scanner;

/**
 * [Controller] 사용자 입출력 담당.
 * <p>
 * 원칙:
 * - 비즈니스 로직은 절대 여기서 직접 만들지 않는다. Service에 위임.
 * - Repository는 이 클래스에서 "존재조차 모른다". (import 금지)
 * - switch-case 금지 → if/else if로 분기한다.
 * - 예외는 여기서 잡아 사용자 친화적인 메시지로 출력한다.
 */
public class ChickenController {

    private final Scanner sc = new Scanner(System.in);

    // Controller는 Service만 알고 있다.
    private final ChickenService chickenService;
    private final CustomerService customerService;
    private final OrderService orderService;

    // 주문 ID를 매번 입력받지 않도록, 자동 증가용 카운터를 둔다.
    // (사용자 경험을 위해 Controller에서 관리하는 편의 값)
    private int orderSequence = 1;

    public ChickenController(ChickenService chickenService,
                             CustomerService customerService,
                             OrderService orderService) {
        this.chickenService = chickenService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    /**
     * 프로그램 전체 루프.
     */
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int menu = readInt();

            // switch 대신 if ~ else if 로 분기.
            if (menu == 1) {
                handleChickenList();
            } else if (menu == 2) {
                handleRegisterCustomer();
            } else if (menu == 3) {
                handleOrder();
            } else if (menu == 4) {
                handleOrderList();
            } else if (menu == 0) {
                System.out.println("종료합니다. 안녕히 가세요! 🍗");
                running = false;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== 🍗 치킨 왕국 =====");
        System.out.println("1. 메뉴 조회  2. 고객 등록  3. 주문하기  4. 주문 내역  0. 종료");
        System.out.print("선택 > ");
    }

    /**
     * nextInt()와 nextLine() 혼용 시 남는 개행문자를 처리하기 위한 유틸.
     */
    private int readInt() {
        try {
            int value = Integer.parseInt(sc.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            // 숫자가 아닌 입력은 -1로 처리하여 "잘못된 입력" 분기로 보낸다.
            return -1;
        }
    }

    private String readLine() {
        return sc.nextLine().trim();
    }

    /**
     * 1번: 치킨 목록 출력. toString 금지 → getter로 직접 조립.
     */
    private void handleChickenList() {
        List<Chicken> chickens = chickenService.getAllChickens();
        System.out.println();
        System.out.println("[치킨 메뉴]");
        for (Chicken c : chickens) {
            // getter로 값을 꺼내 문자열을 직접 조립한다.
            System.out.println(
                    c.getId() + ". " + c.getName() + " - " + c.getPrice() + "원"
            );
        }
    }

    /**
     * 2번: 고객 등록. 잘못된 등급 입력은 커스텀 예외로 잡아 안내.
     */
    private void handleRegisterCustomer() {
        System.out.print("[고객 ID 입력] ");
        int id = readInt();

        System.out.print("[고객 이름 입력] ");
        String name = readLine();

        System.out.print("[등급 입력 - NORMAL / VIP / NEWBIE] ");
        String grade = readLine();

        try {
            customerService.registerCustomer(id, name, grade);
            System.out.println("고객이 등록되었습니다: " + name);
        } catch (IllegalArgumentException e) {
            // 커스텀 예외들이 모두 IllegalArgumentException을 상속하므로
            // 여기서 한 번에 잡을 수 있다.
            System.out.println("[오류] " + e.getMessage());
        }
    }

    /**
     * 3번: 주문 처리. 각종 커스텀 예외를 잡아 안내.
     */
    private void handleOrder() {
        System.out.print("[고객 ID 입력] ");
        int customerId = readInt();

        System.out.print("[치킨 ID 입력] ");
        int chickenId = readInt();

        try {
            Order order = orderService.order(orderSequence, customerId, chickenId);

            // 등급별 안내 메시지 (여기서만 분기해서 "출력 문구"만 다르게 한다.
            //  실제 할인 계산은 이미 Service에서 전략 패턴으로 처리됨.)
            Customer customer = customerService.getCustomer(customerId);
            if (customer.getGrade().equals("VIP")) {
                System.out.println("[등급 확인] VIP 고객님! 10% 할인 적용됩니다.");
            } else if (customer.getGrade().equals("NEWBIE")) {
                System.out.println("[등급 확인] 신규 고객님! 20% 할인 적용됩니다.");
            } else {
                System.out.println("[등급 확인] 일반 고객님. 할인이 적용되지 않습니다.");
            }

            System.out.println("결제 금액: " + order.getFinalPrice()
                    + "원 (원가 " + order.getOriginalPrice() + "원)");
            System.out.println("주문이 완료되었습니다! 🎉");

            orderSequence++; // 다음 주문 번호로 증가
        } catch (IllegalArgumentException e) {
            System.out.println("[오류] " + e.getMessage());
        }
    }

    /**
     * 4번: 주문 내역 출력.
     */
    private void handleOrderList() {
        List<Order> orders = orderService.getAllOrders();
        System.out.println();
        System.out.println("[주문 내역]");
        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.");
            return;
        }
        for (Order o : orders) {
            System.out.println(
                    "주문#" + o.getOrderId()
                            + " | 고객ID=" + o.getCustomerId()
                            + " | 치킨ID=" + o.getChickenId()
                            + " | 결제=" + o.getFinalPrice() + "원"
                            + " (원가 " + o.getOriginalPrice() + "원)"
            );
        }
    }
}