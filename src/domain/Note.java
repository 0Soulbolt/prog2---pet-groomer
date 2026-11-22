package domain;

public class Note {
    private static String id;
    private static String name;
    private static int durationExtra;

    public Note(String id, String name, int durationExtra) {
        this.id = id;
        this.name = name;
        this.durationExtra = durationExtra;
    }

    public String getId() { return id; }
    public static String getName() { return name; }
    public static int getDurationExtra() { return durationExtra; }
}
