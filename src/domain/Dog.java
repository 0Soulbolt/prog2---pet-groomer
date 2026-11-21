package domain;

import java.util.List;

public abstract class Dog extends Pet {
    private static final int baseDuration = 60;
    private static final int baseFee = 40;

    public Dog(String name, int age, double weight, String breed, String owner, List<Notes> notes) {
        super(name, age, weight, breed, owner, notes);
    }

    public int getBaseDuration() { return baseDuration; }
    public int getBaseFee() { return baseFee; }

    @Override
    public int estimateExtraDuration() {
        int extra = getWeight() > 6.0 ? 10 : 0 + getWeight() < 3.0 ? -10 : 0 + getAge() < 0.25 ? -10 : 0 + getAge() > 1.5 ? 10 : 0;

        return extra;
    }

    @Override
    public double calculateFeeMultiplier() {
        double multiplier = getWeight() > 20.0 ? 1.25 : 1.0;


        return multiplier;
    }

}
