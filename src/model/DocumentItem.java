package model;

public class DocumentItem extends VaultItem {
    private String filePath;

    public DocumentItem(String name, String filePath) {
        super(name);
        this.filePath = filePath;
    }

    @Override
    public String getDetails() {
        return "Document: " + getName() + " stored at " + filePath;
    }
}

