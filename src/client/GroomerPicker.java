package client;

import domain.Groomer;

import java.util.Scanner;

public class GroomerPicker {
    private static Scanner scanner;

    public GroomerPicker(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Rögzített gondozó nélkül nem lehet foglalni.");
        }
        this.scanner = scanner;
    }

    public Groomer groomer
}
