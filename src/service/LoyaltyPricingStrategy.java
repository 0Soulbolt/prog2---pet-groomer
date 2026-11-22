package service;

import client.PetAdministrator;
import client.ServicePicker;
import domain.Groomer;
import domain.Service;
import domain.Note;
import domain.Pet;

import java.util.List;

public class LoyaltyPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Service> services, List<Note> notes, Pet pet, Groomer groomer) {
        double total = pet.getBaseFee();

        for (Service service : ServicePicker.selectedServices) {
            total += (Service.getServicePrice() + (Service.getServiceDuration() * groomer.getHourlyRate())) * 0.8 * pet.calculateFeeMultiplier();
        }

        for (Note note : PetAdministrator.petnotes) {
            total+= (Note.getDurationExtra() * groomer.getHourlyRate());
        }

        return total;
    }
}
