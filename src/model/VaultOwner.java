package model;

public class VaultOwner extends User {

    public VaultOwner(String name, String email, String passwordHash) {
        super(name, email, passwordHash);
    }

    @Override
    public String getRole() {
        return "OWNER";
    }
}