public abstract class Pet {
    private int id;
    private String name;
    private  int age; // Years
    private double weight; //KG
    private String breed;
    private String owner;
    private String notes;


    public Pet(int id, String name, int age, double weight, String breed, String owner, String notes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
        this.owner = owner;
        this.notes = notes;
    }

    public int getId() { return id; }

    public String getName() { return  name; }

    public int getAge() { return age; }

    public double getWeight() { return weight; }

    public String getBreed() { return breed; }

    public String getOwner() { return owner; }

    public String getNotes() { return notes; }
}
