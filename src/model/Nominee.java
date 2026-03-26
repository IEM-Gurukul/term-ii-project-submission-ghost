package model;

import java.io.Serializable;

public class Nominee implements Serializable {
    private String name;
    private String email;
    private String relation;

    public Nominee(String name, String email, String relation) {
        this.name = name;
        this.email = email;
        this.relation = relation;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRelation() { return relation; }
}
