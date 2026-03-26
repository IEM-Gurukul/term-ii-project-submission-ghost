package gui;

import javax.swing.*;

public class FileUploadGUI extends JFrame {
    public FileUploadGUI() {
        setTitle("Upload File");
        setSize(300, 200);
        setLayout(new java.awt.GridLayout(0, 1));

        JButton uploadButton = new JButton("Upload File");
        uploadButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "File upload feature coming soon!");
        });

        add(uploadButton);
        setVisible(true);
    }
}
