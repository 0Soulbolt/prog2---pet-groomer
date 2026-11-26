package client;

import domain.pet.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetAdministrator {
    private Scanner scanner;
    public Pet pet;

    public PetAdministrator(List<Note> notes, Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Rögzített kisállat nélkül nem indítható el a foglalás.");
        }
        this.scanner = scanner;
        this.pet = readPet();
    }

    public Pet readPet() {
        System.out.println("Kérem adja meg a kisállata következő adatait: ");
        int type = askPetType(scanner);
        String name = askPetName(scanner);
        String gender = askPetGender(scanner);
        double age = askPetAge(scanner);
        double weight = askWeight(scanner);
        String breed = askPetBreed(scanner);
        List<Note> petnotes = askNotes(Notes.Notes(), scanner);

        if (type == 1) {
            Dog dog = new Dog(name, gender, age, weight, breed, petnotes);
            return dog;
        } else if (type == 2 ) {
            Cat cat = new Cat(name, gender, age, weight, breed, petnotes);
            return cat;
        }

        return null;
    }

    private int askPetType(Scanner scanner) {


        System.out.println("Milyen kisállatról van szó?");
        System.out.println("1. Kutya");
        System.out.println("2. Macska");
        System.out.print("Válassza kis és írja be a hozzá tartozó sorszámot: ");
        while (true) {
            String typeS = scanner.nextLine();
            try {
                int type = Integer.parseInt(typeS);
                if ((type < 0 || type > 2)) {
                    System.out.println("Érvénytelen választás, próbálja újra!");
                    scanner.nextLine();
                    askPetType(scanner);
                }
                return type;
            } catch (InputMismatchException e) {
                System.out.println("Érvénytelen bemenet, próbálja újra!");

            } catch (NumberFormatException e) {
                System.out.println("Érvénytelen bemenet, próbálja újra!");
            }
        }
    }

    private String askPetName(Scanner scanner) {
        System.out.println("Hogy hívják a kisállatot?");
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Érvénytelen név, próbálja újra");
            }
            else {
                return name;
            }
        }

    }

    private String askPetGender(Scanner scanner) {
            System.out.println("Mi a neme?");
            System.out.println("F - Nő");
            System.out.println("M - Férfi");
            String gender = scanner.nextLine().trim().toUpperCase();
            while ( "F".equals(gender)== false && "M".equals(gender) == false){
                System.out.println("Nem létező bemenet, kérem próbálja újra (F - Nő, M -Férfi)");
                gender = scanner.nextLine().trim().toUpperCase();
            }
        return gender;
    }

    private double askPetAge(Scanner scanner) {
        System.out.print("Milyen idős a kisállat: ");
        while (true) {
            try {
                String ageS = scanner.nextLine().trim();
                double age = Double.parseDouble(ageS);

                if (age <= 0) {
                    System.out.println("Nem megfelelő érték, próbálja újra");
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Nem érvényes szám, próbája újra.");
            }
        }
    }

    private double askWeight(Scanner scanner) {
        double weight = 0;
        System.out.print("Hány kilós: ");
        while (true) {
            try {
                String weightString = scanner.nextLine().replace(',', '.').trim();
                weight = Double.parseDouble(weightString);

                if (weight <= 0.0) {
                    System.out.println("0 - nál nem lehet kisebb a kisállat súlya, próbálja újra");
                }
                return weight;
            } catch (NumberFormatException e) {
                System.out.println("Nem felel meg a bevitel (számot adj meg, pl 12.5 vagy 13,8 vagy 20 )");
            }
        }
    }

    private String askPetBreed(Scanner scanner) {
        String breed = null;
        System.out.println("Milyen fajta a kisállat? (Nem kötelező)");
        breed = scanner.nextLine().trim();

        if (breed == null) {
            System.out.println("Érvénytelen fajta, próbálja újra");
            askPetBreed(scanner);
        }
        return breed;
    }

    private List<Note> askNotes(List<Note> notes, Scanner scanner) {
        List<Note> PetNotes = new ArrayList<Note>();
        int ans = 3;
        System.out.println("Válassza ki mely tulajdonságok igazak a kisállatára: (1/0 - igen/nem)");

        for (int i = 0; i < notes.size(); i++) {
            System.out.print(notes.get(i).getName() + " ");
            String anS = scanner.nextLine().trim();
            try {
                ans = Integer.parseInt(anS);
            } catch (NumberFormatException e) {
                System.out.println("Nem megfelelő bevitel");
                i--;
            }
            if ( ans == 1 ) {
                PetNotes.add(notes.get(i));
            }
            else if ( ans > 1 || ans < 0 ) {
                System.out.println("Nem megfelelő válasz, próbálja újra");
                scanner.nextLine();
                i--;
            }
        }
        return PetNotes;
    }
}
