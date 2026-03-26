package model;

public class MedicalItem extends VaultItem {
    private String recordId;

    public MedicalItem(String name, String recordId) {
        super(name);
        this.recordId = recordId;
    }

    @Override
    public String getDetails() {
        return "Medical Record: " + getName() + " (ID: " + recordId + ")";
    }
}
