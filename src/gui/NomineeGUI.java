package gui;

import manager.UserManager;
import manager.VaultManager;

import javax.swing.*;
import java.awt.*;

public class NomineeGUI extends JFrame {

    public NomineeGUI() {

        setTitle("Assign Nominee");
        setSize(300,150);
        setLayout(new GridLayout(2,2));

        JTextField email = new JTextField();
        JButton assign = new JButton("Assign");

        assign.addActionListener(e -> {
            try {
                VaultManager.getInstance()
                    .assignNominee("vault1", email.getText(), new UserManager());

                JOptionPane.showMessageDialog(this, "Nominee Assigned!");
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(new JLabel("Nominee Email"));
        add(email);
        add(assign);

        setVisible(true);
    }
}