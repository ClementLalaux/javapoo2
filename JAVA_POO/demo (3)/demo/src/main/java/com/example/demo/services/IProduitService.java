package com.example.demo.services;

import com.example.demo.entities.Produit;

import java.util.List;

public interface IProduitService {
    boolean create(Produit p);
    boolean update(Produit p);

    boolean delete(Produit p);

    Produit findById(int id);

    List<Produit> findAll();

}
