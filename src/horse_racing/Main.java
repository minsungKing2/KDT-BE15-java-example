package horse_racing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HorseRepository horseRepository = new HorseRepository();
        JockeyRepository jockeyRepository = new JockeyRepository();
        RaceRepository raceRepository = new RaceRepository();

        HorseService horseService = new HorseService(horseRepository);
        JockeyService jockeyService = new JockeyService(jockeyRepository);
        RaceService raceService = new RaceService(raceRepository);
        StrategyService strategyService = new StrategyService();
        PrizeCalculator prizeCalculator = new OfficialPrizeCalculator();
        Scanner scanner = new Scanner(System.in);

        RaceController controller = new RaceController(
                horseService,
                jockeyService,
                raceService,
                strategyService,
                prizeCalculator,
                scanner);
        controller.run();

    }

}
