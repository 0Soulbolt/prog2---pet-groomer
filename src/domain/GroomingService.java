package domain;

public class GroomingService {
    private final int id;
    private String name;
    private int duration;
    private int price;

    public GroomingService(int id, String name, int duration, int price) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public int getServiceId() { return id; }
    public String  getServiceName() { return name; }
    public int getServiceDuration() { return duration; }
    public int getServicePrice() { return price; }
}
