package domain.owner;

public class Owner {
    private String name;
    private String pword;

    public Owner(String name, String pword) {
        this.name = name;
        this.pword = pword;
    }

    public String getOwnerName() { return name; }

    public String getPword() { return pword; }
}
