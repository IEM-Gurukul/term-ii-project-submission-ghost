package model;

public class MedicalItem extends VaultItem {

    private String reportType;

    public MedicalItem(String name,String reportType){
        super(name,"Medical");
        this.reportType=reportType;
    }

}