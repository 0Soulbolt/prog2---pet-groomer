package strategy;

import domain.groomer.Groomer;
import domain.service.Service;
import domain.pet.Note;
import domain.pet.Pet;

import java.util.List;

public interface PricingStrategy {
    boolean appliesTo(int level);
    double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer);
}
