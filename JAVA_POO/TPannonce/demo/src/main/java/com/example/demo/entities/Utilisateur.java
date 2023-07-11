package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mail;
    private String mdp;
    private Boolean statut;
    private Boolean actif;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private List<Annonce> annonces;

    public Utilisateur() {
    }

    public Utilisateur(String mail, String mdp, Boolean statut, Boolean actif) {
        this.mail = mail;
        this.mdp = mdp;
        this.statut = statut;
        this.actif = actif;
    }

    public Utilisateur(String mail, String mdp, Boolean statut, Boolean actif, List<Annonce> annonces) {
        this.mail = mail;
        this.mdp = mdp;
        this.statut = statut;
        this.actif = actif;
        this.annonces = annonces;
    }

    public Utilisateur(Integer id, String mail, String mdp, Boolean statut, Boolean actif, List<Annonce> annonces) {
        this.id = id;
        this.mail = mail;
        this.mdp = mdp;
        this.statut = statut;
        this.actif = actif;
        this.annonces = annonces;
    }
}
