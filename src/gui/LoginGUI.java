package gui;

import auth.AuthService;
import manager.UserManager;
import model.VaultOwner;
import auth.PasswordHasher;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    private UserManager userManager;
    private AuthService authService;

    public LoginGUI() {
        userManager = new UserManager();
        authService = new AuthService(userManager);

        // Dummy user (for testing)
        try {
            userManager.registerUser(
                new VaultOwner("Admin", "admin@mail.com", PasswordHasher.hash("1234"))
            );
        } catch(Exception e){}

        setTitle("Legacy Lock - Login");
        setSize(350,200);
        setLayout(new GridLayout(3,2));

        JTextField email = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            try {
                authService.login(email.getText(), new String(password.getPassword()));
                new DashboardGUI();
                dispose();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(new JLabel("Email"));
        add(email);
        add(new JLabel("Password"));
        add(password);
        add(loginBtn);

        setVisible(true);
    }
}