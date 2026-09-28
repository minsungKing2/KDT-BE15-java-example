package horse_racing;

import java.util.HashMap;

public class HorseRepository {

    private final HashMap<Integer, Horse> store = new HashMap<>();

    private int nextNumber = 1;

    private int nextId() {
        int id = nextNumber;
        nextNumber += 1;
        return id;
    }

    public Horse save(String name) {
        int id = nextId();
        Horse horse = new Horse(id, name);
        store.put(id, horse);
        return horse;
    }

    public Horse findById(int id) {
        Horse horse = store.get(id);
        if (horse == null) {
            throw new HorseNotFoundException("말을 찾을 수 없습니다. 번호 : " + id);
        }
        return horse;
    }

}
