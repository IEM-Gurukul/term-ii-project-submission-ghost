package persistence;

import manager.VaultManager;
import model.Vault;
import java.io.IOException;
import java.util.List;

public class VaultRepository {
    private static final String VAULT_FILE = "vaults.dat";

    public static void saveVaults(VaultManager manager) {
        try {
            FileStorage.saveObject(manager.getAllVaults(), VAULT_FILE);
            System.out.println("Vaults saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving vaults: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadVaults(VaultManager manager) {
        try {
            Object obj = FileStorage.loadObject(VAULT_FILE);
            if (obj instanceof List<?>) {
                List<Vault> vaults = (List<Vault>) obj;
                vaults.forEach(v -> manager.createVault(v.getId(), v.getOwner()));
                System.out.println("Vaults loaded successfully.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading vaults: " + e.getMessage());
        }
    }
}
