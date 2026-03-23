package manager;

import model.User;
import exception.DuplicateUserException;

import java.util.HashMap;

public class UserManager {

    private HashMap<String, User> users = new HashMap<>();

    // Register user
    public void registerUser(User user) throws DuplicateUserException {
        if(users.containsKey(user.getEmail())) {
            throw new DuplicateUserException("User already exists with email: " + user.getEmail());
        }
        users.put(user.getEmail(), user);
    }

    // Get user
    public User getUser(String email) {
        return users.get(email);
    }

    // Check if exists
    public boolean isRegistered(String email) {
        return users.containsKey(email);
    }
}