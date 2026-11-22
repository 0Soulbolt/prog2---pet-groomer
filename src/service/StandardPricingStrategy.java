package service;

import client.ServicePicker;
import domain.GroomingService;
import domain.Pet;

import java.util.List;

public class StandardPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(List<GroomingService> services, Pet pet) {
        int total = 0;
        for (GroomingService service : ServicePicker.selectedServices) {
            total += GroomingService.getServicePrice();
        }
        return total;
    }
}
