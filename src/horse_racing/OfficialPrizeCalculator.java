package horse_racing;

public class OfficialPrizeCalculator implements PrizeCalculator {
    @Override
    public int prizeOf(int rank) {
        if (rank == 1) {
            return 100;
        } else if (rank == 2) {
            return 40;
        } else if (rank == 3) {
            return 20;
        } else {
            return 0;
        }
    }
}
