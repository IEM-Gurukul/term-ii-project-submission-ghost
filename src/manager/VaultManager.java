package manager;

import model.User;
import model.Vault;
import model.Nominee;
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

    public Vault createVault(String id, User owner) {
        Vault vault = new Vault("RestoredVault-" + id, owner);
        vaults.add(vault);
        return vault;
    }

    public List<Vault> getVaultsByUser(User user) {
        return vaults.stream()
                     .filter(v -> v.getOwner().equals(user))
                     .collect(Collectors.toList());
    }

    public void assignNominee(String vaultName, Nominee nominee) {
        for (Vault v : vaults) {
            if (v.getName().equals(vaultName)) {
                v.setNominee(nominee);
            }
        }
    }

    public List<Vault> getAllVaults() { return vaults; }
    public void setVaults(List<Vault> vaults) { this.vaults = vaults; }
}
