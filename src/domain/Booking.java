package domain;

import client.PetAdministrator;
import client.ServicePicker;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final int id;
    private static int nextId = 1;
    private final Pet pet;
    private Groomer groomer;
    private LocalDateTime appointmentStart;
    private LocalDateTime appointmentEnd;
    private List<Service> services;
    private int price;
    private BookingStatus status;
    private final int duration;

    public Booking(Pet pet, Groomer groomer, LocalDateTime appointmentStart, List<Service> services) {
        this.id = generateNextId();
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null.");
        }
        if (groomer == null) {
            throw new IllegalArgumentException("Groomer cannot be null.");
        }
        /*
        if (!groomer.getavailability()) {
            throw new IllegalStateException("Groomer is not available.");
        }
        */
        if (appointmentStart == null) {
            throw new IllegalArgumentException("Start time cannot be null.");
        }
        if (services == null || services.isEmpty()) {
            throw new IllegalArgumentException("At least one grooming service is required.");
        }

        this.pet = pet;
        this.groomer = groomer;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        //this.services = chosenServices();
        this.price = price;
        //this.status = status;
        this.duration = calcDuration(ServicePicker.selectedServices, PetAdministrator.petnotes, PetAdministrator.readPet() );
    }

    public int getBookingId() { return id; }
    public Pet getPet() { return pet; }
    public Groomer getGroomer() { return groomer; }
    public LocalDateTime getAppointment() { return appointmentStart; }
    public List<Service> getId() { return services; }
    public int getPrice() { return price; }
    //public BookingStatus status() { return status; };

    private static synchronized int generateNextId() {
        return nextId++;
    }

    private static int calcDuration(List<Service> services, List<Note> notes, Pet pet) {
        int total = pet.getBaseDuration();

        for (Service service : ServicePicker.selectedServices) {
            total += Service.getServiceDuration();
        }

        for (Note note : PetAdministrator.petnotes) {
            total+= Note.getDurationExtra();
        }

        total += pet.estimateExtraDuration();
        return  total;
    }
}
