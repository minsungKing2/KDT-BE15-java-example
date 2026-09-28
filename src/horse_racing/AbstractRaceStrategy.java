package horse_racing;

public abstract class AbstractRaceStrategy implements RaceStrategy {
    private final String label;

    protected AbstractRaceStrategy(String label) {
        this.label = label;
    }

    // 핵심 메서드 (템플릿 메서드 패턴) 순서는 고정됨. run() 만 동적으로 달라짐.
    // 템플릿 메서드 패턴 - 부모가 전체 순서를 메서드 하나로 박아 두고, 자식은 그 순서 중 달라져야 하는 칸만 채우는 방식이다.
    @Override
    public final int execute(int round) {
        prepare();
        int pace = run(round);
        return finish(pace);
    }

    protected void prepare() {

    }

    protected abstract int run(int round);

    protected int finish(int pace) {
        return pace;
    }

    @Override
    public String label() {
        return label;
    }
}
