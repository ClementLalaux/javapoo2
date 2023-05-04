package org.example.model;

public class Voiture {

    private int id;
    private String nom;
    private int annee;
    private int puissanceCheveaux;
    private float prix;

    public Voiture(String nom, int annee, int puissanceCheveaux, float prix) {
        this.nom = nom;
        this.annee = annee;
        this.puissanceCheveaux = puissanceCheveaux;
        this.prix = prix;
    }

    public Voiture(int id,String nom, int annee, int puissanceCheveaux, float prix) {
        this(nom, annee, puissanceCheveaux, prix);
        this.id=id;
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

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getPuissanceCheveaux() {
        return puissanceCheveaux;
    }

    public void setPuissanceCheveaux(int puissanceCheveaux) {
        this.puissanceCheveaux = puissanceCheveaux;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
