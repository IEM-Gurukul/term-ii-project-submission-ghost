package model;

public class PasswordItem extends VaultItem {
    private String username;
    private String password;

    public PasswordItem(String title, String username, String password) {
        super(title);
        this.username = username;
        this.password = password;
    }

    @Override
    public String getType() {
        return "PASSWORD";
    }
}