package gui;

import manager.VaultManager;
import model.Nominee;

import javax.swing.*;
import java.awt.*;

public class NomineeGUI extends JFrame {
    private VaultManager vaultManager;

    public NomineeGUI() {
        vaultManager = VaultManager.getInstance();

        setTitle("Assign Nominee");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nominee Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Nominee Email:");
        JTextField emailField = new JTextField();
        JButton assignBtn = new JButton("Assign");

        assignBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            Nominee nominee = new Nominee(name, email, "hashedPasswordHere");
            vaultManager.assignNominee("vault1", nominee);
            JOptionPane.showMessageDialog(this, "Nominee assigned successfully!");
        });

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(new JLabel()); // spacer
        add(assignBtn);

        setVisible(true);
    }
}
