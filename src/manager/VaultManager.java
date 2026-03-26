package manager;

import model.Vault;
import model.VaultOwner;
import model.Nominee;
import model.VaultItem;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VaultManager {
    private static VaultManager instance;
    private ConcurrentHashMap<String, Vault> vaults;

    private VaultManager() {
        vaults = new ConcurrentHashMap<>();
    }

    public static synchronized VaultManager getInstance() {
        if (instance == null) instance = new VaultManager();
        return instance;
    }

    public void createVault(String id, VaultOwner owner) {
        if (vaults.containsKey(id)) {
            throw new RuntimeException("Duplicate Vault ID: " + id);
        }
        vaults.put(id, new Vault(id, owner));
    }

    public Vault getVault(String id) {
        return vaults.get(id);
    }

    public List<Vault> getAllVaults() {
        return vaults.values().stream().collect(Collectors.toList());
    }

    public void assignNominee(String vaultId, Nominee nominee) {
        Vault vault = vaults.get(vaultId);
        if (vault != null) {
            vault.setNominee(nominee);
        }
    }

    public void addItemToVault(String vaultId, VaultItem item) {
        Vault vault = vaults.get(vaultId);
        if (vault != null) {
            vault.addItem(item);
        }
    }
}
