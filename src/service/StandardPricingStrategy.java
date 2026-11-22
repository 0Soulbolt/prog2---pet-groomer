package service;

import client.PetAdministrator;
import client.ServicePicker;
import domain.GroomingService;
import domain.Note;
import domain.Pet;

import java.util.List;

public class StandardPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(List<GroomingService> services, List<Note> notes, Pet pet) {
        int total = pet.getBaseFee();

        for (GroomingService service : ServicePicker.selectedServices) {
            total += GroomingService.getServicePrice();
        }

        for (Note note : PetAdministrator.petnotes) {
            total+= Note.getDurationExtra()/5;
        }

        return total;
    }
}
