package model;

import strategy.ReleaseCondition;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vault {
    private String vaultId;
    private VaultOwner owner;
    private Nominee nominee;
    private List<VaultItem> items;
    private ReleaseCondition condition;

    public Vault(String vaultId, VaultOwner owner) {
        this.vaultId = vaultId;
        this.owner = owner;
        this.items = new ArrayList<>();
    }

    public String getId() { return vaultId; }
    public VaultOwner getOwner() { return owner; }

    public void addItem(VaultItem item) { items.add(item); }
    public List<VaultItem> getItems() { return items; }

    public void setNominee(Nominee nominee) { this.nominee = nominee; }
    public Nominee getNominee() { return nominee; }

    public void setCondition(ReleaseCondition condition) { this.condition = condition; }
    public ReleaseCondition getCondition() { return condition; }

    // Streams + Collections
    public String listItemDetails() {
        return items.stream()
                .map(VaultItem::getDetails)
                .collect(Collectors.joining("\n"));
    }
}


