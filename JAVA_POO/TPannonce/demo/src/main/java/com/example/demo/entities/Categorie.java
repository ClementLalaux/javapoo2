package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @ManyToMany(mappedBy = "categories")
    private List<Annonce> annonces;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }
}
