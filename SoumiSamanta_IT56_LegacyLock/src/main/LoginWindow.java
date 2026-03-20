package main;

import javax.swing.*;
import java.awt.event.*;
import auth.PasswordHasher;
import manager.UserManager;
import model.User;

public class LoginWindow {

    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserManager userManager;

    public LoginWindow(UserManager userManager) {
        this.userManager = userManager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Legacy Lock Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 20, 80, 25);
        frame.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 20, 200, 25);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 200, 25);
        frame.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 100, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        frame.setVisible(true);
    }

    private void loginUser() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        User user = userManager.getUser(email);
        if(user != null && user.authenticate(PasswordHasher.hash(password))) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
            frame.dispose();
            // Open Dashboard
            new DashboardWindow(userManager, user);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid email or password!");
        }
    }
}