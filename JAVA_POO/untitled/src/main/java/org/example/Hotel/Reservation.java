package org.example.Hotel;

public class Reservation {

    private String numero;
    private Boolean valide;
    private Client client;
    private Chambre chambre;

    public Reservation(String numero, Boolean valide, Client client, Chambre chambre) {
        this.numero = numero;
        this.valide = valide;
        this.client = client;
        this.chambre = chambre;
    }
}
