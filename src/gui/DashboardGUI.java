package gui;

import manager.VaultManager;

import javax.swing.*;
import java.awt.*;

public class DashboardGUI extends JFrame {

    private VaultManager vaultManager;

    public DashboardGUI() {
        vaultManager = VaultManager.getInstance();

        setTitle("Dashboard");
        setSize(400,300);
        setLayout(new FlowLayout());

        JButton uploadBtn = new JButton("Upload File");
        JButton nomineeBtn = new JButton("Assign Nominee");

        uploadBtn.addActionListener(e -> new FileUploadGUI());
        nomineeBtn.addActionListener(e -> new NomineeGUI());

        add(uploadBtn);
        add(nomineeBtn);

        setVisible(true);
    }
}