package model;

import java.io.Serializable;

public class Vault implements Serializable {
    private String name;
    private User owner;
    private Nominee nominee;

    public Vault(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() { return name; }
    public User getOwner() { return owner; }

    public void setNominee(Nominee nominee) { this.nominee = nominee; }
    public Nominee getNominee() { return nominee; }
}


