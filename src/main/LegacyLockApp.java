package main;

import gui.LoginGUI;
import manager.UserManager;
import model.User;
import auth.PasswordHasher;

public class LegacyLockApp {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        User admin = new User("Admin", "admin@mail.com", PasswordHasher.hashPassword("1234"));
        try {
            userManager.registerUser(admin);
        } catch (Exception e) {
            System.err.println("Admin already registered.");
        }

        // Launch login GUI
        new LoginGUI();
    }
}
