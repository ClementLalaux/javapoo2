package com.example.demo.service.impl;

import com.example.demo.entity.Personne;
import com.example.demo.service.PersonneService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Override
    public List<Personne> getAllPersonne() {
        Personne personne1 = new Personne(1,"Lalaux","Clement");

        List<Personne> personnes = Arrays.asList(personne1);
        return personnes;
    }

    @Override
    public void addPersonne(Personne personne) {
        getAllPersonne().add(personne);
    }
}
