package chapter02.chicken;

public class ChickenNotFoundException extends IllegalArgumentException {
    public ChickenNotFoundException(int id) {
        super("존재하지 않는 치킨 ID입니다 : " + id);
    }
}
