package auth;

import manager.UserManager;
import model.User;
import exception.AuthenticationException;

public class AuthService {

    private UserManager userManager;

    public AuthService(UserManager userManager) {
        this.userManager = userManager;
    }

    public User login(String email, String password) throws AuthenticationException {

        User user = userManager.getUser(email);

        if(user == null) {
            throw new AuthenticationException("User not found!");
        }

        String hashed = PasswordHasher.hash(password);

        if(!user.getPasswordHash().equals(hashed)) {
            throw new AuthenticationException("Incorrect password!");
        }

        Session session = new Session(user);
        SessionManager.createSession(session);

        return user;
    }
}