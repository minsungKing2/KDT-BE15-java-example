package horse_racing;

import java.util.HashMap;

public class JockeyRepository {

    HashMap<Integer, Jockey> store = new HashMap<>();

    private int nextNumber = 1;

    private int nextId() {
        int id = nextNumber;
        nextNumber += 1;
        return id;
    }

    public Jockey save(String name) {
        int id = nextId();
        Jockey jockey = new Jockey(id, name);
        store.put(id, jockey);
        return jockey;
    }

    public Jockey findById(int id) {
        Jockey jockey = store.get(id);
        if (jockey == null) {
            throw new JockeyNotFoundException("기수를 찾을 수 없습니다. 번호 : " + id);
        }
        return jockey;
    }

}
