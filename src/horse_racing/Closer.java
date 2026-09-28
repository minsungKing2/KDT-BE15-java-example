package horse_racing;

public class Closer extends AbstractRaceStrategy {

    protected Closer() {
        super("추입");
    }

    // AbstractRaceStrategy.run 을 구현한다. 추입은 3라운드가 가장 크다.
    @Override
    protected int run(int round) {
        if (round == 1) {
            return 16;
        } else if (round == 2) {
            return 28;
        } else if (round == 3) {
            return 42;
        } else {
            return 0;
        }
    }
}
