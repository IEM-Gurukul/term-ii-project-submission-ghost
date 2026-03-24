package gui;

import manager.VaultManager;
import model.DocumentItem;

import javax.swing.*;
import java.io.File;

public class FileUploadGUI extends JFrame {

    public FileUploadGUI() {
        setTitle("Upload File");
        setSize(400,200);

        JButton uploadBtn = new JButton("Choose File");

        uploadBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showOpenDialog(null);

            if(res == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();

                try {
                    VaultManager.getInstance()
                        .addItem("vault1", new DocumentItem(file.getName(), file.getPath()));

                    JOptionPane.showMessageDialog(this, "File Uploaded!");
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        });

        add(uploadBtn);
        setVisible(true);
    }
}