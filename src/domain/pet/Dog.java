package domain.pet;

import java.util.List;

public class Dog extends Pet {
    private static final int baseDuration = 210;
    private static final int baseFee = 70;

    public Dog(String name, String gender, double age, double weight, String breed, List<Note> notes) {
        super(name, gender, age, weight, breed, notes);
    }

    public int getBaseDuration() { return baseDuration; }
    public int getBaseFee() { return baseFee; }

    @Override
    public int estimateExtraDuration() {
        int extra = (getWeight() > 10 ? 10 : 0) + (getWeight() < 35 ? -10 : 0) + (getAge() < 0.5 ? -10 : 0) + (getAge() > 8 ? 10 : 0);

        return extra;
    }

    @Override
    public double calculateFeeMultiplier() {
        double multiplier = getWeight() < 10 ? 0.8 : 1 + getWeight() > 35 ? 1.3 : 1 + getAge() < 0.5 ? 0.8 : 1 + getAge() > 8 ? 1.2 : 1;

        return multiplier;
    }

}