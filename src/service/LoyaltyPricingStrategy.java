package service;

import client.PetAdministrator;
import client.ServicePicker;
import domain.GroomingService;
import domain.Note;
import domain.Pet;

import java.util.List;

public class LoyaltyPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(List<GroomingService> services, List<Note> notes,Pet pet) {
        int total = pet.getBaseFee();

        for (GroomingService service : ServicePicker.selectedServices) {
            total += GroomingService.getServicePrice()/2;
        }

        for (Note note : PetAdministrator.petnotes) {
            total+= Note.getDurationExtra()/10;
        }
        return total;
    }
}
