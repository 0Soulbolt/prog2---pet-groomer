package client;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetAdministrator {
    private static Scanner scanner;
    public static List<Note> petnotes;

    public PetAdministrator(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Rögzített kisállat nélkül nem indítható el a foglalás.");
        }
        this.scanner = scanner;
        this.petnotes = askNotes();
    }

    public static Pet readPet() {
        System.out.println("Kérem adja meg a kisállata következő adatait: ");
        int type = askPetType();
        String name = askPetName();
        boolean gender = askPetGender();
        double age = askPetAge();
        double weight = askWeight();
        String breed = askPetBreed();
        String owner = askOwnerName();
        List<Note> notes = askNotes();

        if (type == 1) {
            Dog dog = new Dog(name, gender, age, weight, breed, owner, notes);
            return dog;
        } else if (type == 2 ) {
            Cat cat = new Cat(name, gender, age, weight, breed, owner, notes);
            return cat;
        }
        return null;
    }

    private static int askPetType() {
            System.out.println("Milyen kisállatról van szó?");
            System.out.println("1. Kutya");
            System.out.println("2. Macska");
            System.out.print("Válassza kis és írja be a hozzá tartozó sorszámot: ");
            int type = scanner.nextInt();

            if (type != 1 || type != 2) {
                System.out.println("Érvénytelen választás, próbálja újra!");
                askPetType();
            }
            return type;
    }

    private static String askPetName() {
        String name = null;
        System.out.println("Hogy hívják a kisállatot?");
        name = scanner.nextLine().trim();

        if (name == null) {
            System.out.println("Érvénytelen név, próbálja újra");
            askPetName();
        }
        return name;
    }

    private static boolean askPetGender() {
            System.out.println("Mi a neme?");
            System.out.println("F - Nő");
            System.out.println("M - Férfi");
            String gender = scanner.nextLine().trim();
            boolean genderbool = true;

            if (gender != "F" || gender != "M") {
                System.out.println("Érvénytelen válasz, próbálja újra!");
                askPetGender();
            if (gender == "M") {
                genderbool = false;
            }
        }
        return genderbool;
    }

    private static double askPetAge() {
        System.out.print("Milyen idős a kisállat: ");
        double age = scanner.nextDouble();

        if (age <= 0) {
            System.out.println("Nem megfelelő érték, próbálja újra");
            askPetAge();
        }

        return age;
    }

    private static double askWeight() {
        System.out.print("Hány kilós: ");
        Double weight = scanner.nextDouble();
            if (weight <= 0 || weight == null) {
                System.out.println("Nem felel meg a bevitel (számot adj meg, pl 12.5 vagy 13 )");
                askWeight();
            }
        return weight;
    }

    private static String askPetBreed() {
        String breed = null;
        System.out.println("Milyen fajta a kisállat? (Ha nem tudja írja, hogy nem tudom)");
        breed = scanner.nextLine().trim();

        if (breed == null) {
            System.out.println("Érvénytelen fajta, próbálja újra");
            askPetName();
        }
        return breed;
    }

    private static String askOwnerName() {
        String name = null;
        System.out.println("Hogy hívják önt?");
        name = scanner.nextLine().trim();

        if (name == null) {
            System.out.println("Érvénytelen név, próbálja újra");
            askOwnerName();
        }
        return name;
    }

    private static List<Note> askNotes() {
        List<Note> PetNotes = new ArrayList<Note>();
        System.out.println("Válassza ki mely tulajdonságok igazak a kisállatára: (1/0)");
        for (int i = 0; i < Notes.Notes().size(); i++) {
            int ans = scanner.nextInt();
            System.out.println(Note.getName());
            if ( ans == 1 ) {
                PetNotes.add(Notes.Notes().get(i));
            }
            if (ans != 0 || ans != 1 ) {
                System.out.println("Nem megfelelő válasz, próbálja újra");
                i--;
            }
        }
        return PetNotes;
    }
}
