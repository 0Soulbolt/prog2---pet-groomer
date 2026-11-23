package client;

import domain.groomer.Groomer;
import domain.groomer.Groomers;

import java.util.List;
import java.util.Scanner;

public class GroomerPicker {
    private static Scanner scanner;

    public GroomerPicker(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Rögzített gondozó nélkül nem lehet foglalni.");
        }
        this.scanner = scanner;
    }

    public Groomer selectGroomer(List<Groomer> groomers) {

        System.out.println("Alábbi gondozóink érhetők el: ");
        for (Groomer groomer : groomers) {
            System.out.println("Név: " + groomer.getName() + ", Órabér: " + groomer.getHourlyRate());
        }
        System.out.println("Kérem válassza ki egyik gondozónk (Írja be az azonosítóját)");
        int GroomerId = scanner.nextInt();
        while (GroomerId > 0 && GroomerId < groomers.size()) {
            System.out.println("Nem létező azonosító, kérem próbálja újra");
            GroomerId = scanner.nextInt();
        }

        Groomer selectedGroomer = groomers.get(GroomerId-1);
        return selectedGroomer;
    }
}
