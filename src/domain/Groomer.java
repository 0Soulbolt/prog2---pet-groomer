package domain;

import java.awt.*;

public class Groomer {
    private final int id;
    private static int nextId;
    private String name;
    private List speciecatalogue;
    private double hourlyRate;
    private boolean availability;

    public Groomer(String name, List speciecatalogue, double hourlyRate, boolean availability) {
        this.id = generateNextId();
        this.name = name;
        this.speciecatalogue = speciecatalogue;
        this.hourlyRate = hourlyRate;
        this.availability = availability;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List getSpeciecatalogue() { return speciecatalogue; }
    public double getHourlyRate() { return hourlyRate; }
    public boolean getavailability() { return availability; }

    private static synchronized int generateNextId() {
        return nextId++;
    }
}
