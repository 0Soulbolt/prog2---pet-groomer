package domain.booking;

import java.util.List;

public class Services {
    public static List<Service> Services() {
        return List.of(
            new Service("Fürdetés és szárítás", 45,50),
            new Service("Karomvágás", 15,20),
            new Service("Fültisztítás", 10,20),
            new Service("Teljes kozmetika / nyírás", 60,100)
        );
    }

    public static Service findByName(String name) {
        return Services().stream()
                .filter(service -> Service.getServiceName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ismeretlen szolgáltatás: " + name));
    }

    public int GroomingServiceDuration(List<Service> services) {
            int total = 0;
            for (int i = 0; i < services.size(); i++) {
                total += services.get(i).getServiceDuration();
            }
        return total;
    }

}