package com.example.demo.repository;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnonceRepository extends CrudRepository<Annonce,Integer> {

    public List<Annonce>  findByUtilisateur(Utilisateur utilisateur);

}
