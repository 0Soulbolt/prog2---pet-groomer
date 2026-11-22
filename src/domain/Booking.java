package domain;

import domain.Groomer;
import domain.GroomingService;
import domain.Pet;
import domain.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final int id;
    private static int nextId = 1;
    private final Pet pet;
    private Groomer groomer;
    private LocalDateTime appointmentStart;
    private LocalDateTime appointmentEnd;
    private List<GroomingService> services;
    private int price;
    private BookingStatus status;
    private final int duration;

    public Booking( Pet pet, Groomer groomer, LocalDateTime appointmentStart, List<GroomingService> services) {
        this.id = generateNextId();
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null.");
        }
        if (groomer == null) {
            throw new IllegalArgumentException("Groomer cannot be null.");
        }
        if (!groomer.getavailability()) {
            throw new IllegalStateException("Groomer is not available.");
        }
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
        this.services = services;
        this.price = price;
        this.status = status;
        this.duration = calcDuration(this.services, this.pet);
    }

    public int getBookingId() { return id; }
    public Pet getPet() { return pet; }
    public Groomer getGroomer() { return groomer; }
    public LocalDateTime getAppointment() { return appointmentStart; }
    public List<GroomingService> getId() { return services; }
    public int getPrice() { return price; }
    public BookingStatus status() { return status; };

    private static synchronized int generateNextId() {
        return nextId++;
    }

    private static int calcDuration(List<GroomingService> services, Pet pet) {
        int total = 0;

        for (GroomingService : services) {
            total += service.getServiceDuration();
        }

        total += pet.estimateExtraDuration();

        return  total;
    }

}
