package domain.booking;

import client.CreateBooking;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BookingFileWriter {
    private final Path filePath;

    public BookingFileWriter(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public void save(Booking booking) {
        //String line = booking.toString() + System.lineSeparator();
        String line = booking.getOwner().getOwnerName() + " " + booking.getOwner().getPword() /*+ " " + booking.getPrice()*/ + System.lineSeparator();
        try {
            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }
            Files.writeString(
                    filePath,
                    line,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Nem sikerült menteni a foglalást: " + e.getMessage());
        }
        System.out.println("Sikeresen mentve lett a foglalás");
    }
}
