package horse_racing;

public class JockeyNotFoundException extends IllegalArgumentException {
    public JockeyNotFoundException(String message) {
        super(message);
    }
}
