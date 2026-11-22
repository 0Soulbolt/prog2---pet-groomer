package domain;
import java.util.List;

public abstract class Pet {
    private static int id;
    private static int nextId = 1;
    private String name;
    private boolean gender;
    private double age; // Years
    private double weight; //KG
    private String breed;
    private String owner;
    private List<Note> notes;

    public Pet(String name, boolean gender, double age, double weight, String breed, String owner, List<Note> notes) {
        this.id = generateNextId();
        setName(name);
        this.gender = gender;
        setAge(age);
        setWeight(weight);
        setBreed(breed);
        setOwner(owner);
    }

    //public int getPetId() { return id; }

    public String getName() { return  name; }
    public double getAge() { return age; }
    public double getWeight() { return weight; }
    public String getBreed() { return breed; }
    public String getOwner() { return owner; }
    public List<Note> getNotes() { return notes; }

    public abstract double calculateFeeMultiplier();

    public abstract int estimateExtraDuration(); //minutes

    private static synchronized int generateNextId() {
        return nextId++;
    }

    public void setName(String name) {
        this.name = ValidationUtils.requireNonBlank(name, "name");
    }
    public void setAge(double age) {
        this.age = ValidationUtils.requirePos(age, "age");
    }
    public void setWeight(double weight) {
        this.weight = ValidationUtils.requirePos(weight, "weight");
    }
    public void setBreed(String breed) {
        this.breed = ValidationUtils.requireNonBlank(breed, "breed");
    }
    public void setOwner(String owner) {
        this.owner = ValidationUtils.requireNonBlank(owner, "owner");
    }
}