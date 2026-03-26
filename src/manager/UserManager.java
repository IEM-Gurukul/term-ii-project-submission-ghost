package manager;

import exception.DuplicateUserException;
import model.User;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private static UserManager instance;
    private ConcurrentHashMap<String, User> users;

    private UserManager() {
        users = new ConcurrentHashMap<>();
    }

    public static synchronized UserManager getInstance() {
        if (instance == null) instance = new UserManager();
        return instance;
    }

    public void registerUser(User user) throws DuplicateUserException {
        if (users.containsKey(user.getEmail())) {
            throw new DuplicateUserException("User with email " + user.getEmail() + " already exists.");
        }
        users.put(user.getEmail(), user);
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }
}
