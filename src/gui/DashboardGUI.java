package gui;

import manager.VaultManager;
import model.Vault;
import model.VaultOwner;
import monitor.VaultMonitor;

import javax.swing.*;
import java.awt.*;

public class DashboardGUI extends JFrame {
    private VaultManager vaultManager;
    private VaultMonitor vaultMonitor;

    public DashboardGUI() {
        vaultManager = VaultManager.getInstance();
        vaultMonitor = new VaultMonitor(vaultManager);
        vaultMonitor.start();

        setTitle("Legacy Lock - Dashboard");
        setSize(500, 400);
        setLayout(new GridLayout(4, 1));

        JButton createVaultBtn = new JButton("Create Vault");
        JButton viewVaultsBtn = new JButton("View Vaults");
        JButton nomineeBtn = new JButton("Assign Nominee");
        JButton logoutBtn = new JButton("Logout");

        createVaultBtn.addActionListener(e -> {
            VaultOwner owner = new VaultOwner("Admin", "admin@mail.com", "hashedPasswordHere");
            vaultManager.createVault("vault1", owner);
            JOptionPane.showMessageDialog(this, "Vault created successfully!");
        });

        viewVaultsBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Vaults:\n");
            for (Vault v : vaultManager.getAllVaults()) {
                sb.append("ID: ").append(v.getId())
                  .append(" Owner: ").append(v.getOwner().getEmail())
                  .append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        nomineeBtn.addActionListener(e -> new NomineeGUI());
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginGUI();
        });

        add(createVaultBtn);
        add(viewVaultsBtn);
        add(nomineeBtn);
        add(logoutBtn);

        setVisible(true);
    }
}
