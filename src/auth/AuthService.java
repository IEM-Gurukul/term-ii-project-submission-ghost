package auth;

import manager.UserManager;
import model.User;

public class AuthService {
    private final UserManager userManager;

    public AuthService() {
        this.userManager = UserManager.getInstance();
    }

    public User authenticate(String email, String passwordHash) {
        User user = userManager.getUserByEmail(email);
        if (user != null && user.getPasswordHash().equals(passwordHash)) {
            return user;
        }
        return null;
    }
}
