package com.example.demo.service;

import com.example.demo.repository.AuteurRepository;
import com.example.demo.entity.Auteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    public void save(Auteur auteur){
        auteurRepository.save(auteur);
    }

    public Auteur findById(Integer id){
        return auteurRepository.findById(id).get();
    }

    public List<Auteur> findAll(){
        return (List<Auteur>) auteurRepository.findAll();
    }

    public Auteur updateAuteur(Integer id , Auteur auteur){
        Auteur auteurUpdate = auteurRepository.findById(id).get();
        auteurUpdate.setEmail(auteur.getEmail());
        auteurUpdate.setNom(auteur.getNom());
        return auteurRepository.save(auteurUpdate);
    }

    public void deleteAuteur(Integer id){
        Auteur auteurDelete = auteurRepository.findById(id).get();
        auteurRepository.delete(auteurDelete);
    }
}
