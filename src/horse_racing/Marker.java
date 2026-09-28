package horse_racing;

public class Marker extends AbstractRaceStrategy{

    protected Marker() {
        super("선입");
    }

    @Override
    protected int run(int round) {
        if (round == 1) {
            return 30;
        } else if (round == 2) {
            return 30;
        } else if (round == 3) {
            return 30;
        } else {
            return 0;
        }
    }
}
