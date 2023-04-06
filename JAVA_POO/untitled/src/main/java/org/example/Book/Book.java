package org.example.Book;

public class Book {

    private static int nb;

    private int id;
    private String name;
    private Auteur[] auteurs;
    private Editeur editeur;
    private int publishingYears;
    private int amoutOfPages;
    private double prix;
    private CoverType coverType;

    public Book( String name, Auteur[] auteurs, Editeur editeur, int publishingYears, int amoutOfPages, double prix, CoverType coverType) {
        this.id = ++nb;
        this.name = name;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.publishingYears = publishingYears;
        this.amoutOfPages = amoutOfPages;
        this.prix = prix;
        this.coverType = coverType;
    }

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Book.nb = nb;
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

    public Auteur[] getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Auteur[] auteurs) {
        this.auteurs = auteurs;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public int getPublishingYears() {
        return publishingYears;
    }

    public void setPublishingYears(int publishingYears) {
        this.publishingYears = publishingYears;
    }

    public int getAmoutOfPages() {
        return amoutOfPages;
    }

    public void setAmoutOfPages(int amoutOfPages) {
        this.amoutOfPages = amoutOfPages;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

}
