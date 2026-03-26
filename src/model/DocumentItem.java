package model;

public class DocumentItem extends VaultItem {

    private String filePath;          
    private byte[] encryptedData;     


    public DocumentItem(String title, String filePath) {
        super(title, "Document");
        this.filePath = filePath;
    }


    public DocumentItem(String title, byte[] encryptedData) {
        super(title, "Document");
        this.encryptedData = encryptedData;
    }

    public String getFilePath() {
        return filePath;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }
}