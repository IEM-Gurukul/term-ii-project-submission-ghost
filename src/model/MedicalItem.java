package model;

public class MedicalItem extends VaultItem {
    private String reportDetails;

    public MedicalItem(String title, String reportDetails) {
        super(title);
        this.reportDetails = reportDetails;
    }

    @Override
    public String getType() {
        return "MEDICAL";
    }
}