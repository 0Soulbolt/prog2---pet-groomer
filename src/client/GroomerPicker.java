package client;

import domain.groomer.Groomer;
import domain.groomer.Groomers;

import java.util.List;
import java.util.Scanner;

public class GroomerPicker {
    private Scanner scanner;

    public GroomerPicker(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Rögzített gondozó nélkül nem lehet foglalni.");
        }
        this.scanner = scanner;
    }

    public static Groomer selectGroomer(List<Groomer> groomers, Scanner scanner) {

        System.out.println("Alábbi gondozóink érhetők el: ");
        for (Groomer groomer : groomers) {
            System.out.println("Azonosító: " + groomer.getId() + ", Név: " + groomer.getName() + ", Órabér: " + groomer.getHourlyRate());
        }
        System.out.print("Kérem válassza ki egyik gondozónk (Írja be az azonosítóját): ");
            while (true) {
                String GroomerS = scanner.nextLine().trim();

                try {
                    int GroomerId = Integer.parseInt(GroomerS);
                    if (GroomerId < 0 || GroomerId > groomers.size()) {
                        System.out.println("\nNem létező azonosító, kérem próbálja újra: ");
                        continue;
                    }

                    return groomers.get(GroomerId - 1);

                } catch (NumberFormatException e) {
                    System.out.println("Nem megfelelő bevitel, próbálja újra");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Nem létező gondozó azonosító.");
                }
        }
    }
}
