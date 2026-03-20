package model;

public class Nominee extends User {

    public Nominee(String name, String email, String passwordHash) {
        super(name, email, passwordHash);
    }

    @Override
    public String getRole() {
        return "NOMINEE";
    }
}