package manager;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private List<User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void registerUser(User user) throws Exception {
        if (getUserByEmail(user.getEmail()) != null) {
            throw new Exception("User already exists with email: " + user.getEmail());
        }
        users.add(user);
    }

    public User getUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    // For persistence
    public List<User> getAllUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
