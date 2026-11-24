package client;

import domain.service.Service;
import domain.service.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicePicker {
    private Scanner scanner;
    public List<Service> selectedServices;

    public ServicePicker(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Egy szolgáltatást mindenképpen meg kell adni.");
        }
        this.scanner = scanner;
        this.selectedServices = selectServices(Services.AvailableServices(), scanner);
    }

    public List<Service> selectServices(List<Service> services, Scanner scanner) {
        List<Service> selectedServices = new ArrayList<>();

        System.out.println("Elérhető szolgáltatások: ");
        for (int i = 0; i < services.size(); i++) {
            Service s = services.get(i);
            System.out.println((i+1) + ". " + s.getServiceName() + " (" + s.getServiceDuration() + " perc)");
        }

        System.out.print("Add meg a kívánt szolgáltatások sorszámát vesszővel elválasztva: ");
        String line = scanner.next();

        for (String num : line.split(",")) {
            String trimmed = num.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            try {
                int index = Integer.parseInt(trimmed) - 1;
                if (index >= 0 && index < services.size()) {
                    Service chosen = services.get(index);
                    if (!selectedServices.contains(chosen)) {
                        selectedServices.add(chosen);
                    }
                } else {
                    System.out.println("Érvénytelen sorszám kihagyva: " + trimmed);
                }
            } catch (NumberFormatException e) {
                System.out.println("Nem szám, kihagyva: " + trimmed);
            }
        }

        return selectedServices;
    }


}
