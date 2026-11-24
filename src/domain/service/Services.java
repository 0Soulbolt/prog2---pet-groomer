package domain.service;

import java.util.List;

public class Services {
    public static List<Service> AvailableServices() {
        return List.of(
            new Service("Fürdetés és szárítás", 45,50),
            new Service("Karomvágás", 15,20),
            new Service("Fültisztítás", 10,20),
            new Service("Teljes kozmetika / nyírás", 60,100)
        );
    }
/*
    public Service findByName(String name) {
        return AvailableServices().stream()
                .filter(service -> AvailableServices().get().getServiceName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ismeretlen szolgáltatás: " + name));
    }

 */
    public int ServicesPrice(List<Service> services) {
        int total = 0;
        for (Service service : services) {
            total += service.getServicePrice();
        }
        return total;
    }

    public int GroomingServiceDuration(List<Service> services) {
            int total = 0;
            for (int i = 0; i < services.size(); i++) {
                total += services.get(i).getServiceDuration();
            }
        return total;
    }

}