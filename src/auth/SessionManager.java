package manager;

import model.User;
public class SessionManager {
    private static User activeUser;

    public static void setActiveUser(User user) {
        activeUser = user;
    }

    public static User getActiveUser() {
        return activeUser;
    }
}
