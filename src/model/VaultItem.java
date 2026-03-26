package model;

public abstract class VaultItem {
    private String name;

    public VaultItem(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract String getDetails(); // overridden by subclasses
}
