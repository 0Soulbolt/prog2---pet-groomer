package strategy;

import domain.groomer.Groomer;
import domain.booking.Service;
import domain.pet.Note;
import domain.pet.Pet;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer);
}
