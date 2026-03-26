package strategy;

import model.Vault;
import java.time.LocalDateTime;

public class TimeBasedCondition extends ReleaseCondition {
    private LocalDateTime releaseTime;

    public TimeBasedCondition(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public boolean shouldRelease(Vault vault) {
        return LocalDateTime.now().isAfter(releaseTime);
    }
}
