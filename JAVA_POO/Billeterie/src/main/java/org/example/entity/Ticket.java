package org.example.entity;

public class Ticket {

    private int id;
    private int nombre_tickets;
    private Evenement evenement;
    private Client client;

    public Ticket(int nombre_tickets, Evenement evenement, Client client) {
        this.nombre_tickets = nombre_tickets;
        this.evenement = evenement;
        this.client = client;
    }

    public Ticket(int id, int nombre_tickets) {
        this.id = id;
        this.nombre_tickets = nombre_tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre_tickets() {
        return nombre_tickets;
    }

    public void setNombre_tickets(int nombre_tickets) {
        this.nombre_tickets = nombre_tickets;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ticket{" +
                "id=" + id +
                ", nombre_tickets=" + nombre_tickets +
                ", evenement=" + evenement +
                ", client=" + client +
                '}';
    }
}
