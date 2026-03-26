package model;

import java.io.Serializable;

public class Vault implements Serializable {
    private String id;
    private String name;
    private User owner;
    private Nominee nominee;
    private VaultCondition condition;

    public Vault(String name, User owner) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.owner = owner;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public User getOwner() { return owner; }

    public void setNominee(Nominee nominee) { this.nominee = nominee; }
    public Nominee getNominee() { return nominee; }

    public void setCondition(VaultCondition condition) { this.condition = condition; }
    public VaultCondition getCondition() { return condition; }
}

