package com.example.demo.services;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository _categorieRepository;

    public Categorie createCategorie(String nom) throws Exception {
        if(nom == null){
            throw new Exception("Remplir la totalité des champs");
        }
        Categorie categorie = new Categorie(nom);
        if(_categorieRepository.save(categorie) != null){
            return categorie;
        }
        return null;
    }

    public boolean deleteCategorie(int id) throws Exception{
        Categorie categorie = _categorieRepository.findById(id).get();
        if(categorie !=null){
            _categorieRepository.delete(categorie);
            return true;
        }
        throw new Exception("Aucune catégorie avec cet ID");
    }

    public List<Categorie> getAllCategories(){
        return (List<Categorie>) _categorieRepository.findAll();
    }

    public Categorie findById(int id){
        return _categorieRepository.findById(id).get();
    }
}
