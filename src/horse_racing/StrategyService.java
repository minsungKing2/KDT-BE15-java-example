package horse_racing;

public class StrategyService {
    public RaceStrategy choose(int choice) {
        if (choice == 1) {
            return new FrontRunner();
        } else if (choice == 2) {
            return new Closer();
        } else if (choice == 3) {
            return new Marker();
        } else if (choice == 4) {
            return new Pacer();
        } else {
            throw new InvalidStrategyException("전력은 1, 2, 3, 4 입니다.");
        }
    }
}
