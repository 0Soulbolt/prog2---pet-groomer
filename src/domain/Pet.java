package domain;
import java.util.List;

public abstract class Pet {
    private static int id;
    private static int nextId;
    private String name;
    private double age; // Years
    private double weight; //KG
    private String breed;
    private String owner;
    private List<Notes> notes;

    public Pet(String name, double age, double weight, String breed, String owner, List<Notes> notes) {
        this.id = generateNextId();
        setName(name);
        setAge(age);
        setWeight(weight);
        setBreed(breed);
        setOwner(owner);
        this.notes = notes;
    }

    //public int getPetId() { return id; }

    public String getName() { return  name; }
    public double getAge() { return age; }
    public double getWeight() { return weight; }
    public String getBreed() { return breed; }
    public String getOwner() { return owner; }
    public List<Notes> getNotes() { return notes; }

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
