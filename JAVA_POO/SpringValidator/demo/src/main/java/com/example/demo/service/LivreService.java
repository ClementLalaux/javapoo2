package com.example.demo.service;

import com.example.demo.entity.Auteur;
import com.example.demo.repository.LivreRepository;
import com.example.demo.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public void save(Livre livre){
        livreRepository.save(livre);
    }
    public Livre findById(Integer id){
        return livreRepository.findById(id).get();
    }

    public List<Livre> findAll(){
        return (List<Livre>) livreRepository.findAll();
    }

    public Livre updateLivre(Integer id , Livre livre){
        Livre livreUpdate = livreRepository.findById(id).get();
        livreUpdate.setAnnee(livre.getAnnee());
        livreUpdate.setTitre(livre.getTitre());
        livreUpdate.setGenre(livre.getGenre());
        livreUpdate.setAuteur(livre.getAuteur());
        return livreRepository.save(livreUpdate);
    }

    public void deleteLivre(Integer id){
        Livre livreDelete = livreRepository.findById(id).get();
        livreRepository.delete(livreDelete);
    }
}
