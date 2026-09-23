package chapter02.review;

import java.util.HashMap;
import java.util.Map;

public class AnimalRepository {
    private final Map<Long, Animal> store = new HashMap<>();
    private Long sequence = 0L;

    public Animal save(Animal animal) {
        ++sequence;
        animal.assignId(sequence);
        store.put(sequence, animal);
        return animal;
    }

    public Animal findById(Long id) {
        if (store.get(id) == null) return null;
        return store.get(id);
    }

}
