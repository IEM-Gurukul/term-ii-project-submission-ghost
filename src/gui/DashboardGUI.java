package gui;

import javax.swing.*;
import manager.UserManager;
import manager.VaultManager;
import manager.SessionManager;
import model.User;
import model.Vault;
import auth.PasswordHasher;
import java.util.List;

public class DashboardGUI extends JFrame {

    public DashboardGUI(User user) {
        
        SessionManager.setActiveUser(user);

        setTitle("LegacyLock Dashboard - " + user.getName());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.GridLayout(0, 1));

        
        JLabel activeUserLabel = new JLabel("Active User: " + user.getName() + " (" + user.getEmail() + ")");
        add(activeUserLabel);

        JButton registerButton = new JButton("Register New User");
        registerButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter your name:");
            String email = JOptionPane.showInputDialog(this, "Enter your email:");
            String password = JOptionPane.showInputDialog(this, "Enter a password:");

            if (name != null && email != null && password != null) {
                String passwordHash = PasswordHasher.hashPassword(password);
                User newUser = new User(name, email, passwordHash);
                try {
                    UserManager.getInstance().registerUser(newUser);
                    JOptionPane.showMessageDialog(this, "User registered successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Registration failed: " + ex.getMessage());
                }
            }
        });
        add(registerButton);

        JButton createVaultButton = new JButton("Create Vault");
        createVaultButton.addActionListener(e -> {
            User currentUser = SessionManager.getActiveUser();
            String vaultName = JOptionPane.showInputDialog(this, "Enter vault name:");
            if (vaultName != null) {
                Vault vault = new Vault(vaultName, currentUser);
                VaultManager.getInstance().addVault(vault);
                JOptionPane.showMessageDialog(this, "Vault created for " + currentUser.getName());
            }
        });
        add(createVaultButton);

        JButton viewVaultsButton = new JButton("View My Vaults");
        viewVaultsButton.addActionListener(e -> {
            User currentUser = SessionManager.getActiveUser();
            List<Vault> vaults = VaultManager.getInstance().getVaultsByUser(currentUser);
            if (vaults.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No vaults found for " + currentUser.getName());
            } else {
                StringBuilder sb = new StringBuilder("Your Vaults:\n");
                for (Vault v : vaults) {
                    sb.append("- ").append(v.getName()).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            }
        });
        add(viewVaultsButton);

        JButton assignNomineeButton = new JButton("Assign Nominee");
        assignNomineeButton.addActionListener(e -> {
            new NomineeGUI(SessionManager.getActiveUser());
        });
        add(assignNomineeButton);

        JButton uploadFileButton = new JButton("Upload File");
        uploadFileButton.addActionListener(e -> {
            new FileUploadGUI(SessionManager.getActiveUser());
        });
        add(uploadFileButton);

        JButton switchUserButton = new JButton("Switch User");
        switchUserButton.addActionListener(e -> {
            String email = JOptionPane.showInputDialog(this, "Enter email of user to switch:");
            User userToSwitch = UserManager.getInstance().getUserByEmail(email);
            if (userToSwitch != null) {
                SessionManager.setActiveUser(userToSwitch);
                JOptionPane.showMessageDialog(this, "Switched to " + userToSwitch.getName());
                dispose();
                new DashboardGUI(userToSwitch);
            } else {
                JOptionPane.showMessageDialog(this, "User not found!");
            }
        });
        add(switchUserButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            User guest = UserManager.getInstance().getUserByEmail("guest@mail.com");
            if (guest != null) {
                SessionManager.setActiveUser(guest);
                JOptionPane.showMessageDialog(this, "Logged out, back to Guest.");
                dispose();
                new DashboardGUI(guest);
            }
        });
        add(logoutButton);

        setVisible(true);
    }
}

