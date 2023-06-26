package com.example.demo.service;

import com.example.demo.entity.Personne;

import java.util.List;

public interface PersonneService {

    List<Personne> getAllPersonne();

    void addPersonne(Personne personne);

}
