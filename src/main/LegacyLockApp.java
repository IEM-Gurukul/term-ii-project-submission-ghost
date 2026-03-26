package main;

import gui.DashboardGUI;
import model.User;
import auth.PasswordHasher;
import manager.UserManager;

public class LegacyLockApp {
    public static void main(String[] args) {
        
        User guest = new User("Guest", "guest@mail.com", PasswordHasher.hashPassword("guest"));
        try {
            UserManager.getInstance().registerUser(guest);
        } catch (Exception e) {
            System.err.println("Guest already registered.");
        }

    
        new DashboardGUI(guest);
    }
}

