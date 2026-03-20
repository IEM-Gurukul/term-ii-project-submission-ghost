package strategy;

import model.Vault;

public interface ReleaseCondition {

    boolean shouldRelease(Vault vault);
}