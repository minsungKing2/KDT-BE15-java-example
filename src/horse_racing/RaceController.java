package horse_racing;

import java.util.ArrayList;
import java.util.Scanner;

public class RaceController {

    private final HorseService horseService;
    private final JockeyService jockeyService;
    private final RaceService raceService;
    private final StrategyService strategyService;
    private final PrizeCalculator prizeCalculator;
    private final Scanner scanner;

    public RaceController(HorseService horseService,
                          JockeyService jockeyService,
                          RaceService raceService,
                          StrategyService strategyService,
                          PrizeCalculator prizeCalculator,
                          Scanner scanner) {
        this.horseService = horseService;
        this.jockeyService = jockeyService;
        this.raceService = raceService;
        this.strategyService = strategyService;
        this.prizeCalculator = prizeCalculator;
        this.scanner = scanner;
    }

    public void run() {
        boolean going = true;
        while (going) {
            printMenu();
            int menu = scanner.nextInt();
            if (menu == 1) { // 말 등록
                registerHorse();
            } else if (menu == 2) { // 기수 등록
                registerJockey();
            } else if (menu == 3) { // 경기 생성
                createRace();
            } else if (menu == 4) { // 경기 참가
                enter();
            } else if (menu == 5) { // 경치 시작
                startRace();
            } else if (menu == 6) { // 기록 조회
                showRecords();
            } else if (menu == 7) {
                demonstrate();
            } else if (menu == 0) {
                System.out.println("경주를 마칩니다.");
                going = false;
            } else System.out.println("없는 번호입니다.");
        }
    }

    private void printMenu() {
        System.out.println("🏇 서울경마공원");
        System.out.println("1. 말 등록");
        System.out.println("2. 기수 등록");
        System.out.println("3. 경주 만들기");
        System.out.println("4. 참가 등록");
        System.out.println("5. 경주 시작");
        System.out.println("6. 기록 보기");
        System.out.println("7. 전략 체험");
        System.out.println("0. 종료");
        System.out.println("전략은 1선행 2추입 3선입 4균속");
        System.out.print("번호> ");
    }

    private void registerHorse() {
        System.out.print("말 이름> ");
        String name = scanner.nextLine();
        try {
            Horse horse = horseService.register(name);
            System.out.println("🐴 말을 등록했습니다. 번호 " + horse.getId() + ", " + horse.getName());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void registerJockey() {
        System.out.print("기수 이름> ");
        String name = scanner.nextLine();
        try {
            Jockey jockey = jockeyService.register(name);
            System.out.println("👤 기수를 등록했습니다. 번호 " + jockey.getId() + ", " + jockey.getName());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void createRace() {
        System.out.print("경주 이름> ");
        String title = scanner.nextLine();
        try {
            Race race = raceService.create(title);
            System.out.println("🏁 경주를 만들었습니다. 번호 " + race.getId() + ", " + race.getTitle());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void enter() {
        System.out.print("경주 번호> ");
        int raceId = scanner.nextInt();
        System.out.print("말 번호> ");
        int horseId = scanner.nextInt();
        System.out.print("기수 번호> ");
        int jockeyId = scanner.nextInt();
        System.out.print("전략 번호> ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        try {
            Race race = raceService.findById(raceId);
            Horse horse = horseService.findById(horseId);
            Jockey jockey = jockeyService.findById(jockeyId);
            RaceStrategy strategy = strategyService.choose(choice);
            raceService.enter(raceId, horse.getName(), jockey.getName(), choice);
            System.out.println("🎫 참가했습니다. " + race.getTitle() + " / " + horse.getName()
                    + " / " + jockey.getName() + " / " + strategy.label());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void startRace() {
        System.out.print("경주 번호> ");
        int raceId = scanner.nextInt();
        scanner.nextLine();
        try {
            Race race = raceService.findById(raceId);
            if (race.entryCount() < 2) {
                throw new IllegalArgumentException("참가 말이 2마리 미만입니다.");
            }
            raceService.clearRecords(raceId);
            ArrayList<Integer> totals = new ArrayList<>();
            for (int i = 0; i < race.entryCount(); i++) {
                totals.add(0);
            }
            for (int round = 1; round <= 3; round++) {
                ArrayList<Integer> scores = new ArrayList<>();
                for (int i = 0; i < race.entryCount(); i++) {
                    RaceStrategy strategy = strategyService.choose(race.strategyChoiceAt(i));
                    int pace = strategy.execute(round);
                    scores.add(pace);
                    totals.set(i, totals.get(i) + pace);
                }
                ArrayList<Integer> order = rank(scores);
                save(raceId, "🏁 " + race.getTitle() + " " + round + "라운드");
                for (int place = 0; place < order.size(); place++) {
                    int index = order.get(place);
                    RaceStrategy strategy = strategyService.choose(race.strategyChoiceAt(index));
                    String line = (place + 1) + "위 " + race.horseNameAt(index) + " / "
                            + race.jockeyNameAt(index) + " / " + strategy.label() + " / "
                            + scores.get(index);
                    save(raceId, line);
                }
            }
            ArrayList<Integer> finalOrder = rank(totals);
            save(raceId, "🏆 최종 순위");
            for (int place = 0; place < finalOrder.size(); place++) {
                int index = finalOrder.get(place);
                int rankNo = place + 1;
                RaceStrategy strategy = strategyService.choose(race.strategyChoiceAt(index));
                int prize = prizeCalculator.prizeOf(rankNo);
                String line = rankNo + "위 " + race.horseNameAt(index) + " / "
                        + race.jockeyNameAt(index) + " / " + strategy.label() + " / 합계 "
                        + totals.get(index) + " / 상금 " + prize;
                save(raceId, line);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void showRecords() {
        System.out.print("경주 번호> ");
        int raceId = scanner.nextInt();
        scanner.nextLine();
        try {
            ArrayList<String> lines = raceService.recordsOf(raceId);
            if (lines.size() == 0) {
                System.out.println("아직 기록이 없습니다.");
            } else {
                System.out.println("📒 기록");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // 다형성 체험. 람다로 바꾸지 않는다.
    // 컴파일 타입은 RaceStrategy다. 이 반복에서 보이는 메서드는 execute와 label뿐이다.
    // 런타임 타입은 FrontRunner, Closer, Marker, Pacer다.
    // execute는 final이라 몸통은 AbstractRaceStrategy 하나다.
    // 그 몸통이 부르는 run()이 런타임 타입의 run으로 간다.
    private void demonstrate() {
        System.out.println("🎭 전략 체험 1라운드");
        ArrayList<RaceStrategy> strategies = new ArrayList<>();
        strategies.add(new FrontRunner());
        strategies.add(new Closer());
        strategies.add(new Marker());
        strategies.add(new Pacer());
        for (RaceStrategy strategy : strategies) {
            System.out.println(strategy.label() + " " + strategy.execute(1));
        }
    }

    private void save(int raceId, String line) {
        System.out.println(line);
        raceService.addRecord(raceId, line);
    }

    // 왜: 점수가 큰 참가가 앞으로 온다.
    // 점수가 같으면 참가 목록에서 더 앞인 말(먼저 넣은 말)이 앞이다.
    // Integer끼리 == 로 비교하지 않는다. 128 이상은 값이 같아도 객체가 다를 수 있다.
    private ArrayList<Integer> rank(ArrayList<Integer> scores) {
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            order.add(i);
        }
        for (int i = 0; i < order.size(); i++) {
            for (int j = i + 1; j < order.size(); j++) {
                int left = order.get(i);
                int right = order.get(j);
                int leftScore = scores.get(left);
                int rightScore = scores.get(right);
                boolean higher = rightScore > leftScore;
                boolean sameButEarlier = rightScore == leftScore && right < left;
                if (higher || sameButEarlier) {
                    order.set(i, right);
                    order.set(j, left);
                }
            }
        }
        return order;
    }
}
