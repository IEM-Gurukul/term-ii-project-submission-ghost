package gui;

import javax.swing.*;
import manager.UserManager;
import manager.SessionManager;
import model.User;
import auth.PasswordHasher;

public class LoginGUI extends JFrame {
    public LoginGUI() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(new java.awt.GridLayout(0, 1));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String passwordHash = PasswordHasher.hashPassword(new String(passwordField.getPassword()));
            User user = UserManager.getInstance().getUserByEmail(email);
            if (user != null && user.getPasswordHash().equals(passwordHash)) {
                SessionManager.setActiveUser(user);
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new DashboardGUI(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        setVisible(true);
    }
}
