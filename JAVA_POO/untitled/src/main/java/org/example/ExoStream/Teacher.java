package org.example.ExoStream;

public class Teacher {
    private int id;
    private String name;
    private String departement;
    private int startDate;

    public Teacher(int id, String name, String departement, int startDate) {
        this.id = id;
        this.name = name;
        this.departement = departement;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
}
