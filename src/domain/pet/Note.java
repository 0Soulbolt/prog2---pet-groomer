package domain.pet;

public class Note {
    private String id;
    private String name;
    private int durationExtra;

    public Note(String id, String name, int durationExtra) {
        this.id = id;
        this.name = name;
        this.durationExtra = durationExtra;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getDurationExtra() { return durationExtra; }
}
