package chapter02.review;

public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    public Animal requestAnimal(String name) {
        return service.register(name);
    }

}
