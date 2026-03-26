package strategy;

import model.Vault;

public abstract class ReleaseCondition {
    public abstract boolean shouldRelease(Vault vault);
}
