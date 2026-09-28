package horse_racing;

public class JockeyService {
    private final JockeyRepository repository;

    public JockeyService(JockeyRepository repository) {
        this.repository = repository;
    }

    public Jockey register(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("기수 이름이 비어 있습니다.");
        }
        return repository.save(name);
    }

    public Jockey findById(int id) {
        return repository.findById(id);
    }
}
