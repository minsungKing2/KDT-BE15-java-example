package horse_racing;

public class Pacer extends AbstractRaceStrategy{

    protected Pacer() {
        super("균속");
    }

    // AbstractRaceStrategy.run을 구현한다. 균속은 라운드마다 2점씩 오른다.
    @Override
    protected int run(int round) {
        if (round == 1) {
            return 24;
        } else if (round == 2) {
            return 26;
        } else if (round == 3) {
            return 28;
        } else {
            return 0;
        }
    }
}
