package chapter02.chicken;

import java.util.List;

public class ChickenService {

    private final ChickenRepository chickenRepository;

    public ChickenService(ChickenRepository chickenRepository) {
        this.chickenRepository = chickenRepository;
    }

    public void registerChicken(int id, String name, int price) {
        Chicken chicken = new Chicken(id, name, price);
        chickenRepository.save(chicken);
    }

    public List<Chicken> getAllChickens() {
        return chickenRepository.findAll();
    }

    public Chicken getChicken(int id) {
        return chickenRepository.findById(id);
    }

}
