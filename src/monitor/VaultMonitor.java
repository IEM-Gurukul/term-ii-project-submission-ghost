package monitor;

import manager.VaultManager;
import model.Vault;
import strategy.ReleaseCondition;

import java.util.Collection;

public class VaultMonitor extends Thread {

    private VaultManager vaultManager;

    public VaultMonitor() {
        this.vaultManager = VaultManager.getInstance();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(5000);
                Collection<Vault> vaults = vaultManager.getAllVaults();

                for(Vault v : vaults) {
                    ReleaseCondition condition = v.getCondition();

                    if(condition != null && condition.shouldRelease(v)) {
                        releaseVault(v);
                    }
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void releaseVault(Vault vault) {
        System.out.println("Vault Released for Nominee: " + vault.getNominee().getEmail());

        vault.getItems().forEach(item -> {
            System.out.println("Item: " + item.getTitle() + " Type: " + item.getType());
        });
    }
}