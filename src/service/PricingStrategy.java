package service;

import domain.GroomingService;
import domain.Pet;

import java.util.List;

public interface PricingStrategy {
    int calculatePrice(List<GroomingService> services, Pet pet);
}
