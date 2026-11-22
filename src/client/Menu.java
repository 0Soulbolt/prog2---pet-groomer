package client;

import domain.GroomingService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    public Menu(Scanner scanner){
        this.scanner = scanner;
    }
    public void serviceSelector() {
        ServicePicker servicePicker = new ServicePicker(scanner);
        List<GroomingService> chosenServices = servicePicker.selectServices();
    }


}
