package model;

import java.time.LocalDateTime;

public abstract class VaultItem {
    protected String title;
    protected LocalDateTime createdAt;

    public VaultItem(String title) {
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }
}