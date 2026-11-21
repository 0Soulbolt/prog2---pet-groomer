package service;

import domain.Groomer;
import domain.GroomingService;
import domain.Pet;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final int id;
    private final Pet pet;
    private Groomer groomer;
    private LocalDateTime appointment;
    private List<GroomingService> services;
    private int price;
    private BookingStatus status;

    private static int duration(List<GroomingService> services, Pet pet) {

    }

    public Booking(int id, Pet pet, Groomer groomer, LocalDateTime appointment, List<GroomingService> services) {
        this.id = id;
        this.pet = pet;
        this.groomer = groomer;
        this.appointment = appointment;
        this.services = services;
        this.price = price;
        this.status = status;
    }

    public int getBookingId() { return id; }
    public Pet getPet() { return pet; }
    public Groomer getGroomer() { return groomer; }
    public LocalDateTime getAppointment() { return appointment; }
    public List<GroomingService> getId() { return services; }
    public int getPrice() { return price; }
    public BookingStatus status() { return status; };

}
