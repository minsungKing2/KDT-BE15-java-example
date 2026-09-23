package chapter02.review;

public class AnimalService {
    private final AnimalRepository repository;
    private final SoundPolicy soundPolicy;

    public AnimalService(AnimalRepository repository, SoundPolicy policy) {
        this.repository = repository;
        this.soundPolicy = policy;
    }

    public Animal register(String name) {
        String sound = soundPolicy.makeSound(name);
        Animal animal = new Animal(name, sound);
        return repository.save(animal);
    }

    public Animal getAnimal(Long id) {
        return repository.findById(id);
    }
}
