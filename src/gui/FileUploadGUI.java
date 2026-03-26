package gui;

import javax.swing.*;
import java.awt.*;

public class FileUploadGUI extends JFrame {
    public FileUploadGUI() {
        setTitle("Upload File to Vault");
        setSize(400, 200);
        setLayout(new FlowLayout());

        JButton uploadBtn = new JButton("Choose File");
        uploadBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "File uploaded: " + chooser.getSelectedFile().getName());
            }
        });

        add(uploadBtn);
        setVisible(true);
    }
}
