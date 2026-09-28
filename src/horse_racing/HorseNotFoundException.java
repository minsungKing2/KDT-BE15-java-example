package horse_racing;

public class HorseNotFoundException extends IllegalArgumentException {
    public HorseNotFoundException(String message) {
        super(message);
    }
}
