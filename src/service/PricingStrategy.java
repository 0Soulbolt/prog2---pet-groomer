package service;

import domain.GroomingService;
import domain.Note;
import domain.Pet;

import java.util.List;

public interface PricingStrategy {
    int calculatePrice(List<GroomingService> services, List<Note> notes, Pet pet);
}
