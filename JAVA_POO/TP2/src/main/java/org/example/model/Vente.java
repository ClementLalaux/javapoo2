package org.example.model;

import java.util.Date;

public class Vente {

    private int id;
    private int voiture_id;
    private int personne_id;
    private Date date_vente;

    public Vente(int voiture_id, int personne_id, Date date_vente) {
        this.voiture_id = voiture_id;
        this.personne_id = personne_id;
        this.date_vente = date_vente;
    }

    public Vente(int id, int voiture_id, int personne_id, Date date_vente) {
        this(voiture_id, personne_id, date_vente);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoiture_id() {
        return voiture_id;
    }

    public void setVoiture_id(int voiture_id) {
        this.voiture_id = voiture_id;
    }

    public int getPersonne_id() {
        return personne_id;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id = personne_id;
    }

    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }
}
