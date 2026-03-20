package model;

public class PasswordItem extends VaultItem {

    private String username;
    private String password;

    public PasswordItem(String name,String username,String password){
        super(name,"Password");
        this.username=username;
        this.password=password;
    }
}