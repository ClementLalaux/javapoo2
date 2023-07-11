package com.example.demo.repository;

import com.example.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer> {

    public Utilisateur findByMail(String email);

}
