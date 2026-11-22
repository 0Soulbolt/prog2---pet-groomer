package domain;

import java.util.List;

public class Cat extends Pet {
    private static final int baseDuration = 120;
    private static final int baseFee = 50;

    public Cat(String name, boolean gender, double age, double weight, String breed, String owner, List<Note> notes) {
        super(name, gender, age, weight, breed, owner, notes);
    }

    public int getBaseDuration() { return baseDuration; }
    public int getBaseFee() { return baseFee; }

    @Override
    public int estimateExtraDuration() {
        int extra = (getWeight() > 8.0 ? 10 : 0) + (getWeight() < 3.0 ? -10 : 0) + (getAge() < 0.25 ? -10 : 0) + (getAge() > 1.5 ? 10 : 0) + (getNotes().extraMinutes());

        return extra;
    }

    @Override
    public double calculateFeeMultiplier() {
        double multiplier = getWeight() > 8.0 ? 1.25 : 1 + getWeight() < 3.0 ? 0.8 : 1 + getAge() < 0.25 ? 0.8 : 1 + getAge() > 8 ? 1.2 : 1;

        return multiplier;
    }

}