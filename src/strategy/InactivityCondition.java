package strategy;

import model.Vault;

import java.time.LocalDateTime;
import java.time.Duration;

public class InactivityCondition implements ReleaseCondition {

    private long minutes;

    public InactivityCondition(long minutes) {
        this.minutes = minutes;
    }

    @Override
    public boolean shouldRelease(Vault vault) {
        LocalDateTime lastActive = vault.getNominee().getLastActive();
        long inactive = Duration.between(lastActive, LocalDateTime.now()).toMinutes();
        return inactive >= minutes;
    }
}