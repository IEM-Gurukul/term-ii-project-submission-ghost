package model;
import java.time.LocalDateTime;
public abstract class User {

    protected String name;
    protected String email;
    protected String passwordHash;
    protected LocalDateTime lastLogin;
    public User(String name,String email,String passwordHash) {
        this.name=name;
        this.email=email;
        this.passwordHash=passwordHash;
        this.lastLogin=LocalDateTime.now();
    }

    public String getEmail(){
        return email;
    }

    public boolean authenticate(String hash){
        return passwordHash.equals(hash);
    }

    public void updateLogin(){
        lastLogin=LocalDateTime.now();
    }

    public LocalDateTime getLastLogin(){
        return lastLogin;
    }
}