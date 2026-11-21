import java.awt.*;

public class Groomer {
    private final int id;
    private String name;
    private List speciecatalogue;
    private double hourlyRate;
    private boolean availability;

    public Groomer(int id, String name, List speciecatalogue, double hourlyRate, boolean availability) {
        this.id = id;
        this.name = name;
        this.speciecatalogue = speciecatalogue;
        this.hourlyRate = hourlyRate;
        this.availability = availability;
    }

    public int getGroomerId() { return id; }
    public String getName() { return name; }
    public List getSpeciecatalogue() { return speciecatalogue; }
    public double getHourlyRate() { return hourlyRate; }
    public boolean getavailability() { return availability; }

}
