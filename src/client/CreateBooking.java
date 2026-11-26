package client;

import domain.booking.Booking;
import domain.booking.BookingFileReader;
import domain.booking.BookingFileWriter;
import domain.groomer.Groomer;
import domain.groomer.Groomers;
import domain.owner.Owner;
import domain.pet.Notes;
import domain.pet.Pet;
import domain.service.Service;
import domain.service.Services;
import strategy.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CreateBooking {
    Scanner scanner = new Scanner(System.in);

    List<PricingStrategy> allStrategies = List.of(
            new FirstTimePricingStrategy(),
            new StandardPricingStrategy(),
            new LoyaltyPricingStrategy()
    );



    public Booking MakeBooking() {

        Owner owner = Login.Login(scanner);
        PetAdministrator petadministration = new PetAdministrator(Notes.Notes(), scanner);
        Pet pet = petadministration.pet;
        Groomer groomer = GroomerPicker.selectGroomer(Groomers.Groomers(), scanner);
        LocalDateTime appointmentStart = AskBookingDateTime.askBookingDateTime(scanner);
        ServicePicker servicePicker = new ServicePicker(scanner);
        List<Service> services = servicePicker.selectedServices;

        BookingFileReader reader = new BookingFileReader("booking.txt");
        int level = reader.determinePricing(owner);
        StrategySelector selector = new StrategySelector(allStrategies);
        PricingStrategy chosenStrategy = selector.select(level);


        Booking booking = new Booking(owner, pet, groomer, appointmentStart, services, chosenStrategy.calculatePrice(services, pet.getNotes(), pet, groomer));
        scanner.close();
        return booking;
    }


}
c