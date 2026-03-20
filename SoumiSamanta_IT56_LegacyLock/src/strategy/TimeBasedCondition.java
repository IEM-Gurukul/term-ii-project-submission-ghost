package strategy;

import model.Vault;

public class TimeBasedCondition implements ReleaseCondition {

    private long releaseTime;

    public TimeBasedCondition(long releaseTime){
        this.releaseTime=releaseTime;
    }

    public boolean shouldRelease(Vault vault){
        return System.currentTimeMillis()>releaseTime;
    }
}