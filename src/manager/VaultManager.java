package manager;
import model.*;
import exception.DuplicateUserException;

import java.util.*;
import manager.UserManager;
import exception.AuthenticationException;

public class VaultManager {

    private static VaultManager instance;
    private Map<String, Vault> vaults;

    private VaultManager() {
        vaults = new HashMap<>();
    }

    // Singleton Pattern
    public static VaultManager getInstance() {
        if(instance == null) {
            instance = new VaultManager();
        }
        return instance;
    }

    // Create Vault
    public void createVault(String vaultId, VaultOwner owner) throws Exception {
        if(vaults.containsKey(vaultId)) {
            throw new Exception("Vault already exists!");
        }
        vaults.put(vaultId, new Vault(vaultId, owner));
    }

    // Add Item (Overloading concept)
    public void addItem(String vaultId, VaultItem item) throws Exception {
        Vault v = vaults.get(vaultId);
        if(v == null) throw new Exception("Vault not found!");
        v.addItem(item);
    }

    public void addItem(String vaultId, List<VaultItem> items) throws Exception {
        for(VaultItem i : items) {
            addItem(vaultId, i);
        }
    }

    public Vault getVault(String vaultId) {
        return vaults.get(vaultId);
    }

    public Collection<Vault> getAllVaults() {
        return vaults.values();
    }

    public void assignNominee(String vaultId, String nomineeEmail, UserManager userManager) throws Exception {
        Vault vault = vaults.get(vaultId);
        if(vault == null) {
            throw new Exception("Vault not found!");
        }

        if(!userManager.isRegistered(nomineeEmail)) {
            throw new Exception("Nominee must be a registered user!");
        }
        vault.setNominee((model.Nominee) userManager.getUser(nomineeEmail));
    }

    public void createVault(String vaultId, VaultOwner owner) throws Exception {

        for(Vault v : vaults.values()) {
            if(v.getOwner().getEmail().equals(owner.getEmail())) {
            throw new Exception("User already owns a vault!");
            }
        }
        vaults.put(vaultId, new Vault(vaultId, owner));
    }
}