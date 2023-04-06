package org.example.Book;

public class Editeur {

    private static int nb;
    private String editeurName;

    private int id;

    public Editeur(String editeurName) {
        this.editeurName = editeurName;
        this.id = ++nb;
    }

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Editeur.nb = nb;
    }

    public String getEditeurName() {
        return editeurName;
    }

    public void setEditeurName(String editeurName) {
        this.editeurName = editeurName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Editeur{" +
                "editeurName='" + editeurName + '\'' +
                ", id=" + id +
                '}';
    }
}
