package service;

import client.PetAdministrator;
import client.ServicePicker;
import domain.GroomingService;
import domain.Note;
import domain.Notes;
import domain.Pet;

import java.util.List;

public class NotesAdjustedPricingStrategy implements PricingStrategy {
    private final int surchargePerActiveNote;

    public NotesAdjustedPricingStrategy(int surchargePerActiveNote) {
        this.surchargePerActiveNote = surchargePerActiveNote;
    }

    @Override
    public int calculatePrice(List<GroomingService> services, Pet pet) {
        int total = 0;
        for (GroomingService service : ServicePicker.selectedServices) {
            total += GroomingService.getServicePrice();
        }

        for (Note notes : PetAdministrator.petnotes) {
            total+= Note.getDurationExtra()/10;
        }
        return total;
    }
}
