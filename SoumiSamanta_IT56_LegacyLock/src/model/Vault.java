package model;

import java.util.ArrayList;

public class Vault {

    private String vaultId;
    private VaultOwner owner;
    private Nominee nominee;

    private ArrayList<VaultItem> items=new ArrayList<>();

    public Vault(String vaultId,VaultOwner owner){
        this.vaultId=vaultId;
        this.owner=owner;
    }

    public void setNominee(Nominee nominee){
        this.nominee=nominee;
    }

    public void addItem(VaultItem item){
        items.add(item);
    }

    public ArrayList<VaultItem> getItems(){
        return items;
    }
}