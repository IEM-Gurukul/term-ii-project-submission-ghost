package persistence;

import model.Vault;

import java.util.HashMap;

public class VaultRepository {

    private HashMap<String, Vault> db = new HashMap<>();

    public void saveVault(String id, Vault vault) {
        db.put(id, vault);
    }

    public Vault getVault(String id) {
        return db.get(id);
    }
}