package horse_racing;

public class HorseService {
    private final HorseRepository repository;

    public HorseService(HorseRepository repository) {
        this.repository = repository;
    }

    public Horse register(String name) {
        if (name.equals("")){
            throw new IllegalArgumentException("말 이름이 비어있습니다.");
        }
        return repository.save(name);
    }

    public Horse findById(int id) {
        return repository.findById(id);
    }
}
