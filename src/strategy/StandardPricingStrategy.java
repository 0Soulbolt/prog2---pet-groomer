package strategy;

import client.PetAdministrator;
import client.ServicePicker;
import domain.groomer.Groomer;
import domain.booking.Service;
import domain.pet.Note;
import domain.pet.Pet;

import java.util.List;

public class StandardPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer) {
        double total = pet.getBaseFee() * pet.calculateFeeMultiplier();

        for (Service service : ServicePicker.selectedServices) {
            total += (Service.getServicePrice() + (Service.getServiceDuration() * groomer.getHourlyRate())) ;
        }

        for (Note note : PetAdministrator.petnotes) {
            total+= (Note.getDurationExtra() * groomer.getHourlyRate());
        }

        return total;
    }
}
