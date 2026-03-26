package gui;

import javax.swing.*;
import model.User;

public class FileUploadGUI extends JFrame {
    private User currentUser;

    public FileUploadGUI(User user) {
        this.currentUser = user;
        setTitle("Upload File for " + user.getName());
        setSize(300, 200);
        setLayout(new java.awt.GridLayout(0, 1));

        JButton uploadButton = new JButton("Upload File");
        uploadButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "File upload feature coming soon for " + currentUser.getName());
        });

        add(uploadButton);
        setVisible(true);
    }
}

