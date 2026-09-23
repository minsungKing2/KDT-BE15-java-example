package guest;

public class Guest {
    private final int id;
    private final String name;

    public Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
