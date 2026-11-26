package domain.booking;
import domain.owner.Owner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class BookingFileReader {
    private final Path filePath;

    public BookingFileReader(String filePath) {
        this.filePath = Path.of(filePath);
    }
    public List<String> readAllLines() {
        if (!Files.exists(filePath)) {
            return Collections.emptyList();
        }

        try {
            return Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Nem sikerült beolvasni a fájlt: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void printAllBookings() {
        List<String> lines = readAllLines();
        if (lines.isEmpty()) {
            System.out.println("Nincs még elmentett foglalás.");
            return;
        }

        System.out.println("--- Elmentett foglalások ---");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ". " + lines.get(i));
        }
    }
    public int determinePricing(Owner owner) {
        List<String> lines = readAllLines();
        int numOfBookings = 0;
        //String expected = owner.getOwnerName() + " " + owner.getPword();
        //System.out.println("KERESETT: [" + expected + "]");
        String ownerPrefix = owner.getOwnerName() + " " + owner.getPword();
        for (String line : lines) {
            //System.out.println("SOR A FÁJLBAN: [" + line + "]");
            String trimmed = line.trim();
            if (trimmed.contains(ownerPrefix) || trimmed.contains(ownerPrefix + " ") || trimmed.contains(ownerPrefix + ";")) {
                numOfBookings++;
            }
        }
        return numOfBookings;
    }
}
