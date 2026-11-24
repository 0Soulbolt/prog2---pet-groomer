package client;

import domain.booking.Booking;
import domain.groomer.Groomer;
import domain.groomer.Groomers;
import domain.owner.Owner;
import domain.pet.Notes;
import domain.pet.Pet;
import domain.service.Service;
import domain.service.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CreateBooking {
    private final Scanner scanner = new Scanner(System.in);


    public Booking MakeBooking() {

        Owner owner = Login.Login(scanner);
        PetAdministrator petadministration = new PetAdministrator(Notes.Notes(), scanner);
        Pet pet = petadministration.readPet(scanner);
        Groomer groomer = GroomerPicker.selectGroomer(Groomers.Groomers(), scanner);
        LocalDateTime appointmentStart = AskBookingDateTime.askBookingDateTime(scanner);
        ServicePicker servicePicker = new ServicePicker(scanner);
        //List<Service> services = servicePicker.selectServices(Services.AvailableServices(), scanner);

        return null;
    }


}
