package org.example.Hotel;

import java.util.List;

public class Hotel {



    private String nom;
    private List<Chambre> chambres;
    private List<Reservation> reservations;
    private List<Client> clients;

    public Hotel(String nom, List<Chambre> chambres) {
        this.nom = nom;
        this.chambres = chambres;
    }

    public Hotel(String nom, List<Chambre> chambres, List<Reservation> reservations, List<Client> clients) {
        this.nom = nom;
        this.chambres = chambres;
        this.reservations = reservations;
        this.clients = clients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations.add(reservations);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients.add(clients);
    }
}
