package auth;

import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static SessionManager instance;
    private ConcurrentHashMap<String, Session> sessions;

    private SessionManager() {
        sessions = new ConcurrentHashMap<>();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) instance = new SessionManager();
        return instance;
    }

    public void createSession(String email, Session session) {
        sessions.put(email, session);
    }

    public Session getSession(String email) {
        return sessions.get(email);
    }

    public void endSession(String email) {
        sessions.remove(email);
    }
}
