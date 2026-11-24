package domain.booking;

import client.PetAdministrator;
import client.ServicePicker;
import domain.groomer.Groomer;
import domain.owner.Owner;
import domain.pet.Note;
import domain.pet.Pet;
import domain.service.Service;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final int id;
    private static int nextId = 1;
    private final Owner owner;
    private final Pet pet;
    private Groomer groomer;
    private LocalDateTime appointmentStart;
    private LocalDateTime appointmentEnd;
    private List<Service> services;
    private int price;
    //private final int duration;

    public Booking(Owner owner, Pet pet, Groomer groomer, LocalDateTime appointmentStart, List<Service> services) {
        this.id = generateNextId();
        this.owner = owner;
        this.pet = pet;
        this.groomer = groomer;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        //this.services = chosenServices();
        this.price = price;
        //this.status = status;
        //this.duration = calcDuration(ServicePicker.selectServices, PetAdministrator.petnotes, PetAdministrator.readPet() );
    }

    public int getBookingId() { return id; }
    public Pet getPet() { return pet; }
    public Groomer getGroomer() { return groomer; }
    public LocalDateTime getAppointment() { return appointmentStart; }
    public List<Service> getId() { return services; }
    public int getPrice() { return price; }

    private synchronized int generateNextId() {
        return nextId++;
    }
/*
    private static int calcDuration(List<Service> services, List<Note> notes, Pet pet) {
        int total = pet.getBaseDuration();

        for (Service service : ServicePicker.selectedServices) {
            total += Service.getServiceDuration();
        }

        for (Note note : PetAdministrator.askNotes().size()) {
            total+= Note.getDurationExtra();
        }

        total += pet.estimateExtraDuration();
        return  total;
    }
    */
}
