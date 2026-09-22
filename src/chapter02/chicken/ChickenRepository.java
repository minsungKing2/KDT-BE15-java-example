package chapter02.chicken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChickenRepository {

    // private final 꼭 쓰기!
    private final Map<Integer, Chicken> store = new HashMap<>();

    // 저장
    public void save(Chicken chicken) {
        store.put(chicken.getId(), chicken);
    }

    // 조건부 조회 (읽기)
    public Chicken findById(int id) {
        if (store.get(id) == null) {
            throw new ChickenNotFoundException(id);
        }
        return store.get(id);
    }

    // 전체 조회 (읽기)
    public List<Chicken> findAll() {
        return new ArrayList<>(store.values());
    }
}
