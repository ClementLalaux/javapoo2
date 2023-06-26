package com.example.demo2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "equipe_joueur",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "joueur_id"))
    private List<Joueur> joueurs;

}
