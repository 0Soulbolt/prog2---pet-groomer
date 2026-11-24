package client;

import domain.owner.Owner;

import java.util.Scanner;

public class Login {
    private static Scanner scanner;
    private static Owner login;

    public static Owner Login(Scanner scanner) {
        System.out.println("=== Tulajdonosi bejelentkezés ===");

        System.out.print("Kérem jelentkezzen be:\nFelhasználónév: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("A név mező nem lehet üres. Próbálja meg újra a bevitelt.");
            System.out.print("Felhasználónév: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("\n");
        System.out.print("Jelszó: ");
        String pword = scanner.nextLine().trim();

        while (pword.isEmpty()) {
            System.out.println("A jelszó mező nem lehet üres. Próbálja meg újra a bevitelt.");
            System.out.print("Jelszó: ");
            pword = scanner.nextLine().trim();
        }
        System.out.println();

        return new Owner(name, pword);
    }
}
