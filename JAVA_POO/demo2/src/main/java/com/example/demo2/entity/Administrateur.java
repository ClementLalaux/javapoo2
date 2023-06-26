package com.example.demo2.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrateur extends Utilisateur{

    public Administrateur() {
        super();
    }

    public Administrateur(String name) {
        super(name);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



}
