package model;

public class DocumentItem extends VaultItem {
    private String filePath;

    public DocumentItem(String title, String filePath) {
        super(title);
        this.filePath = filePath;
    }

    @Override
    public String getType() {
        return "DOCUMENT";
    }

    public String getFilePath() {
        return filePath;
    }
}