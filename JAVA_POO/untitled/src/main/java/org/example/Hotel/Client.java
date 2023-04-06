package org.example.Hotel;

public class Client {

    private int id;
    private static int nb;
    private String nom;
    private String prenom;
    private String numero;

    public Client(String nom, String prenom, String numero) {
        this.id = ++nb;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Client.nb = nb;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
