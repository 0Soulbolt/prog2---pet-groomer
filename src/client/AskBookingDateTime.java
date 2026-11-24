package client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AskBookingDateTime {

    public static LocalDateTime askBookingDateTime(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.print("Időpont (éééé-hh-nn óó:pp, pl. 2026-12-05 14:30): ");
            String input = scanner.next().trim();

            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Érvénytelen formátum / Nem lehet a múltban az időpont.");
                scanner.nextLine();
            }
        }
    }
}
