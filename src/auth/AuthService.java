package auth;

import exception.AuthenticateUserException;
import manager.UserManager;
import model.User;

public class AuthService {
    private UserManager userManager;

    public AuthService() {
        this.userManager = UserManager.getInstance();
    }

    public User login(String email, String passwordHash) throws AuthenticateUserException {
        User user = userManager.findUserByEmail(email);
        if (user == null) {
            throw new AuthenticateUserException("User not found with email: " + email);
        }
        if (!user.getPasswordHash().equals(passwordHash)) {
            throw new AuthenticateUserException("Invalid password for user: " + email);
        }
        return user;
    }
}
