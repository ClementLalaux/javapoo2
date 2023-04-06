package org.example.Book;

public class Auteur {
    private static int nb;
    private int id;
    private String firstName;
    private String lastName;

    public Auteur( String firstName, String lastName) {
        this.id = ++nb;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Auteur.nb = nb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
