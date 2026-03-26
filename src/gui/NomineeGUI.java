package gui;

import javax.swing.*;
import manager.VaultManager;
import model.Nominee;
import model.User;

public class NomineeGUI extends JFrame {
    private User currentUser;

    public NomineeGUI(User user) {
        this.currentUser = user;
        setTitle("Assign Nominee for " + user.getName());
        setSize(300, 200);
        setLayout(new java.awt.GridLayout(0, 1));

        JButton assignButton = new JButton("Assign Nominee to Vault1");
        assignButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter nominee name:");
            String email = JOptionPane.showInputDialog(this, "Enter nominee email:");
            String relation = JOptionPane.showInputDialog(this, "Enter relation:");
            if (name != null && email != null && relation != null) {
                Nominee nominee = new Nominee(name, email, relation);
                VaultManager.getInstance().assignNominee("vault1", nominee);
                JOptionPane.showMessageDialog(this, "Nominee assigned!");
            }
        });

        add(assignButton);
        setVisible(true);
    }
}
