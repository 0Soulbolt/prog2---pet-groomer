package strategy;

import client.PetAdministrator;
import client.ServicePicker;
import domain.groomer.Groomer;
import domain.service.Service;
import domain.pet.Note;
import domain.pet.Pet;

import java.util.List;

public class StandardPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer) {
        double total = pet.getBaseFee() * pet.calculateFeeMultiplier();

        for (Service service : services) {
            total += (service.getServicePrice() + service.getServicePrice() * groomer.getHourlyRate());
        }

        for (Note note : notes) {
            total+= (note.getDurationExtra() * groomer.getHourlyRate());
        }

        return total;
    }
}
