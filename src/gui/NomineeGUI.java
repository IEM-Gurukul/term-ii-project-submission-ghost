package gui;

import javax.swing.*;
import manager.VaultManager;
import manager.SessionManager;
import model.Nominee;

public class NomineeGUI extends JFrame {
    public NomineeGUI() {
        setTitle("Assign Nominee");
        setSize(300, 200);
        setLayout(new java.awt.GridLayout(0, 1));

        JButton assignButton = new JButton("Assign Nominee to Vault1");
        assignButton.addActionListener(e -> {
            String nomineeName = JOptionPane.showInputDialog(this, "Enter nominee name:");
            if (nomineeName != null) {
                Nominee nominee = new Nominee(nomineeName);
                VaultManager.getInstance().assignNominee("vault1", nominee);
                JOptionPane.showMessageDialog(this, "Nominee assigned!");
            }
        });

        add(assignButton);
        setVisible(true);
    }
}
