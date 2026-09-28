package horse_racing;

import java.util.HashMap;

public class RaceRepository {
    private final HashMap<Integer, Race> store = new HashMap<>();
    private int nextNumber = 1;

    private int nextId() {
        int id = nextNumber;
        nextNumber = nextNumber + 1;
        return id;
    }

    public Race save(String title) {
        int id = nextId();
        Race race = new Race(id, title);
        store.put(id, race);
        return race;
    }

    public Race findById(int id) {
        Race race = store.get(id);
        if (race == null) {
            throw new HorseNotFoundException("경주를 찾을 수 없습니다. 번호=" + id);
        }
        return race;
    }
}