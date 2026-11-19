public abstract class Pet {
    private String name;
    private String breed;
    private  int age;
    private String notes;

    public Pet(String name, String breed, int age, String notes){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.notes = notes;
    }

    public String getName() {
        return  name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getNotes() {
        return notes;
    }
}
