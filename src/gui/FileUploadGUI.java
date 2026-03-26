package gui;

import manager.VaultManager;
import model.DocumentItem;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;

import security.EncryptionService;

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
                    
                    byte[] fileData = Files.readAllBytes(file.toPath());

                    
                    byte[] encryptedData = EncryptionService.encrypt(fileData);

                    
                    DocumentItem item = new DocumentItem(file.getName(), encryptedData);

                    VaultManager.getInstance()
                        .addItem("vault1", item);

                    JOptionPane.showMessageDialog(this, "File Uploaded & Encrypted!");

                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        });

        add(uploadBtn);
        setVisible(true);
    }
}