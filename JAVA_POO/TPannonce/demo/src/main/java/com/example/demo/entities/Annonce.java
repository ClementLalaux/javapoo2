package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String description;
    private Double prix;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "annonce",fetch = FetchType.EAGER)
    private List<Image> images;


    @ManyToMany
    @JoinTable(name = "annonce_categorie",
            joinColumns = @JoinColumn(name = "id_annonce"),
            inverseJoinColumns = @JoinColumn(name = "id_categorie"))
    private List<Categorie> categories = new ArrayList<>();

    public Annonce() {

    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void addCategories(Categorie categorie){
        getCategories().add(categorie);
    }

    public Annonce(String titre, String description, Double prix) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }

    public Annonce(String titre, String description, Double prix, Utilisateur utilisateur) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.utilisateur = utilisateur;
    }
}
