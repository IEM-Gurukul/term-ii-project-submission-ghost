package strategy;

import model.Vault;
import java.time.LocalDateTime;

public class InactivityCondition extends ReleaseCondition {
    private LocalDateTime lastActive;
    private int inactivityMinutes;

    public InactivityCondition(LocalDateTime lastActive, int inactivityMinutes) {
        this.lastActive = lastActive;
        this.inactivityMinutes = inactivityMinutes;
    }

    @Override
    public boolean shouldRelease(Vault vault) {
        LocalDateTime now = LocalDateTime.now();
        return lastActive.plusMinutes(inactivityMinutes).isBefore(now);
    }
}
