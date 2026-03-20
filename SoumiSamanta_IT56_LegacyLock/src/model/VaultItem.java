package model;

public abstract class VaultItem {

    protected String name;
    protected String category;

    public VaultItem(String name,String category){
        this.name=name;
        this.category=category;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }
}