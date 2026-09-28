package horse_racing;

import java.util.ArrayList;

public class Race {
    private final int id;
    private final String title;

    private final ArrayList<String> horseNames;
    private final ArrayList<String> jockeyNames;
    private final ArrayList<Integer> strategyChoices;
    private final ArrayList<String> records;

    public Race(int id, String title) {
        this.id = id;
        this.title = title;
        this.horseNames = new ArrayList<>();
        this.jockeyNames = new ArrayList<>();
        this.strategyChoices = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    public void addEntry(String horseName, String jockeyName, int strategyChoice) {
        horseNames.add(horseName);
        jockeyNames.add(jockeyName);
        strategyChoices.add(strategyChoice);
    }

    public int entryCount() {
        return horseNames.size();
    }

    public String horseNameAt(int index) {
        return horseNames.get(index);
    }

    public String jockeyNameAt(int index) {
        return jockeyNames.get(index);
    }

    public int strategyChoiceAt(int index) {
        return strategyChoices.get(index);
    }

    public void clearRecords() {
        records.clear();
    }

    public void addRecord(String line) {
        records.add(line);
    }

    public ArrayList<String> getRecords() {
        return new ArrayList<>(records);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}