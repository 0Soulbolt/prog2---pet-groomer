package domain;

public class Service {
    //private final int id;
    private static String name;
    private static int duration;
    private static int price;

    public Service(/*int id,*/ String name, int duration, int price) {
        //this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    //public int getServiceId() { return id; }
    public static String getServiceName() { return name; }
    public static int getServiceDuration() { return duration; }
    public static int getServicePrice() { return price; }
}
