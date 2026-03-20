package model;

public class Nominee extends User {

    private String relationship;

    public Nominee(String name,String email,String passwordHash,String relationship){
        super(name,email,passwordHash);
        this.relationship=relationship;
    }

    public String getRelationship(){
        return relationship;
    }

}