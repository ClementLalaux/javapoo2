package com.example.demo2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Joueur extends Utilisateur{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @ManyToMany(mappedBy = "joueurs")
    private List<Equipe> equipes;
}
