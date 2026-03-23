package auth;

public class SessionManager {

    private static Session currentSession;

    public static void createSession(Session session) {
        currentSession = session;
    }

    public static Session getSession() {
        return currentSession;
    }

    public static void logout() {
        currentSession = null;
    }
}