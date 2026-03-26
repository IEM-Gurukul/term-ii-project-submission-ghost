package monitor;

import manager.VaultManager;
import model.Vault;

public class VaultMonitor extends Thread {
    private VaultManager vaultManager;

    public VaultMonitor(VaultManager vaultManager) {
        this.vaultManager = vaultManager;
    }

    @Override
    public void run() {
        while (true) {
            vaultManager.getAllVaults().stream()
                .filter(v -> v.getCondition() != null && v.getCondition().shouldRelease(v))
                .forEach(v -> {
                    System.out.println("Vault " + v.getId() +
                        " released to nominee: " + (v.getNominee() != null ? v.getNominee().getEmail() : "No nominee assigned"));
                });

            try {
                Thread.sleep(5000); // check every 5 seconds
            } catch (InterruptedException e) {
                System.err.println("VaultMonitor interrupted: " + e.getMessage());
            }
        }
    }
}
