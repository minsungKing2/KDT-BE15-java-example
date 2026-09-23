package chapter02.review;

public class CatSoundPolicy implements SoundPolicy {
    @Override
    public String makeSound(String name) {
        if (name == null || name.isEmpty()) return "냐옹";
        return "야옹";
    }
    // int, Integer 의 차이 -> Integer 는 객체처럼 메모리에 저장한다. int 는 변수에 값을 저장
    // Map<K, V> K, V 는 객체 타입만 가능
}
