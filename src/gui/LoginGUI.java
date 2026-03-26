package gui;

import auth.AuthService;
import auth.PasswordHasher;
import auth.Session;
import auth.SessionManager;
import exception.AuthenticateUserException;
import manager.UserManager;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private AuthService authService;
    private SessionManager sessionManager;

    public LoginGUI() {
        authService = new AuthService();
        sessionManager = SessionManager.getInstance();

        setTitle("Legacy Lock - Login");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String passwordHash = PasswordHasher.hashPassword(new String(passwordField.getPassword()));
            try {
                User user = authService.login(email, passwordHash);
                sessionManager.createSession(email, new Session(user));
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new DashboardGUI();
            } catch (AuthenticateUserException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); 
        add(loginButton);

        setVisible(true);
    }
}
