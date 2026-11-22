package client;

import domain.Service;
import domain.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicePicker {
    private final Scanner scanner;
    public static List<Service> selectedServices;

    public ServicePicker(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Egy szolgáltatást mindenképpen meg kell adni.");
        }
        this.scanner = scanner;
        this.selectedServices = selectServices();
    }
    public List<Service> selectServices() {
        List<Service> catalog = Services.Services();
        List<Service> selectedServices = new ArrayList<>();

        System.out.println("Elérhető szolgáltatások: ");
        for (int i = 0; i < catalog.size(); i++) {
            Service s = catalog.get(i);
            System.out.println((i+1) + ". " + Service.getServiceName() + " (" + s.getServiceDuration() + " perc)");
        }

        System.out.print("Add meg a kívánt szolgáltatások sorszámát vesszővel elválasztva: ");
        String line = scanner.nextLine();

        for (String num : line.split(",")) {
            String trimmed = num.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            try {
                int index = Integer.parseInt(trimmed) - 1;
                if (index >= 0 && index < catalog.size()) {
                    Service chosen = catalog.get(index);
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
