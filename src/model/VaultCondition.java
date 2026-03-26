package model;

import java.io.Serializable;

public class VaultCondition implements Serializable {
    private String type;

    public VaultCondition(String type) {
        this.type = type;
    }

    public boolean shouldRelease(Vault vault) {
        return "time".equalsIgnoreCase(type);
    }
}
