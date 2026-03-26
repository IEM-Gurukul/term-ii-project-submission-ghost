package model;

public class PasswordItem extends VaultItem {
    private String password;

    public PasswordItem(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public String getDetails() {
        return "Password Item: " + getName();
    }

    // Overloading
    public String getPassword() { return password; }
    public String getPassword(boolean masked) {
        return masked ? "****" : password;
    }
}
