package org.example.entity;

import java.util.Date;

public class Evenement {

    private int id;
    private String nom;
    private Date date_evenement;
    private double prix;
    private Lieu lieu_evenement;

    public Evenement(String nom, Date date_evenement, double prix, Lieu lieu_evenement) {
        this.nom = nom;
        this.date_evenement = date_evenement;
        this.prix = prix;
        this.lieu_evenement = lieu_evenement;
    }

    public Evenement(int id, String nom, Date date_evenement, double prix, Lieu lieu_evenement) {
        this(nom, date_evenement, prix, lieu_evenement);
        this.id = id;
    }

    public Evenement(int id, String nom, Date date_evenement, double prix) {
        this.id = id;
        this.nom = nom;
        this.date_evenement = date_evenement;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Lieu getLieu_evenement() {
        return lieu_evenement;
    }

    public void setLieu_evenement(Lieu lieu_evenement) {
        this.lieu_evenement = lieu_evenement;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date_evenement=" + date_evenement +
                ", prix=" + prix +
                ", lieu_evenement=" + lieu_evenement +
                '}';
    }
}
