package domain;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public static List<GroomingService> Services() {
        return List.of(
            new GroomingService("Fürdetés és szárítás", 45,50),
            new GroomingService("Karomvágás", 15,20),
            new GroomingService("Fültisztítás", 10,20),
            new GroomingService("Teljes kozmetika / nyírás", 60,100)
        );
    }

    public static GroomingService findByName(String name) {
        return Services().stream()
                .filter(service -> GroomingService.getServiceName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ismeretlen szolgáltatás: " + name));
    }

}