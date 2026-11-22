package service;

import domain.Groomer;
import domain.Service;
import domain.Note;
import domain.Pet;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer);
}
