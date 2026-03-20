package model;

public class DocumentItem extends VaultItem {

    private String filePath;

    public DocumentItem(String name,String filePath){
        super(name,"Document");
        this.filePath=filePath;
    }

    public String getFilePath(){
        return filePath;
    }
}