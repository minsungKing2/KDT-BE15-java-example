package chapter02.review;

public class Animal {

    private Long id;
    private final String name; // 동물 이름
    private final String sound; // 울음 소리 - 전략으로 결정됨

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }
}
