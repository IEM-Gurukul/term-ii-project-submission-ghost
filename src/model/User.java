package model;

import java.time.LocalDateTime;

public abstract class User {
    protected String name;
    protected String email;
    protected String passwordHash;
    protected LocalDateTime lastActive;

    public User(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.lastActive = LocalDateTime.now();
    }

    public abstract String getRole(); // Abstraction

    public void updateActivity() {
        lastActive = LocalDateTime.now();
    }

    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public LocalDateTime getLastActive() { return lastActive; }
}