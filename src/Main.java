import client.CreateBooking;
import client.Login;
import domain.booking.Booking;
import domain.booking.BookingFileReader;
import domain.booking.BookingFileWriter;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CreateBooking createdBooking = new CreateBooking();
        Booking booking = createdBooking.MakeBooking();
        if (booking != null) {
            BookingFileWriter writer = new BookingFileWriter("bookings.txt");
            writer.save(booking);
        }
        BookingFileReader reader = new BookingFileReader("bookings.txt");
        reader.printAllBookings();
    }
}