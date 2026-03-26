package manager;

import model.User;
import model.Vault;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VaultManager {
    private static VaultManager instance;
    private List<Vault> vaults;

    private VaultManager() {
        vaults = new ArrayList<>();
    }

    public static VaultManager getInstance() {
        if (instance == null) {
            instance = new VaultManager();
        }
        return instance;
    }

    public void addVault(Vault vault) {
        vaults.add(vault);
    }

    public List<Vault> getVaultsByUser(User user) {
        return vaults.stream()
                     .filter(v -> v.getOwner().equals(user))
                     .collect(Collectors.toList());
    }

    // For persistence
    public List<Vault> getAllVaults() {
        return vaults;
    }

    public void setVaults(List<Vault> vaults) {
        this.vaults = vaults;
    }
}
