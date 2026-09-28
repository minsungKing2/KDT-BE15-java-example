package horse_racing;

import java.util.ArrayList;

public class RaceService {
    private final RaceRepository repository;

    public RaceService(RaceRepository repository) {
        this.repository = repository;
    }

    public Race create(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("경주 이름이 비어 있습니다.");
        }
        return repository.save(title);
    }

    public Race findById(int id) {
        return repository.findById(id);
    }

    public void enter(int raceId, String horseName, String jockeyName, int strategyChoice) {
        Race race = repository.findById(raceId);

        race.addEntry(horseName, jockeyName, strategyChoice);
    }

    public void clearRecords(int raceId) {
        repository.findById(raceId).clearRecords();
    }

    public void addRecord(int raceId, String line) {
        repository.findById(raceId).addRecord(line);
    }

    public ArrayList<String> recordsOf(int raceId) {
        return repository.findById(raceId).getRecords();
    }
}
