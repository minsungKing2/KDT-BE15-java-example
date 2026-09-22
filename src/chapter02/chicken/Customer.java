package chapter02.chicken;

public class Customer {
    // final - 불변 꼭 붙이기!
    private final int id; // 고객 고유 번호
    private final String name; // 고객 이름
    private final String grade; // 등급 (NORMAL, VIP, NEWBIE)

    public Customer(int id, String name, String grade) {
        this.id = id;
        this.name = name;

        // grade 는 NORMAL, VIP, NEWBIE 만 들어올 수 있음! 제약 사항 만들기!
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}
