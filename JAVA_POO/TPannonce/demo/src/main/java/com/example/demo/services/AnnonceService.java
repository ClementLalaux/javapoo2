package com.example.demo.services;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Image;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repository.AnnonceRepository;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository _annonceRepository;

    @Autowired
    UtilisateurRepository _utilisateurRepository;

    @Autowired
    CategorieRepository _categorieRepository;

    @Autowired
    ImageRepository _imageRepository;


    @Autowired
    UploadService _uploadService;

    public Annonce createAnnonce(String titre, String description, Double prix,Integer idUtilisateur, List<Categorie> categories,List<MultipartFile> images) throws Exception{
        if(titre == null || description == null || prix == null){
            throw new Exception("Remplir la totalité des champs");
        }
        Utilisateur utilisateur = _utilisateurRepository.findById(idUtilisateur).get();
        if(utilisateur == null){
            throw new Exception("Utilisateur non trouvé");
        }
        Annonce annonce = new Annonce(titre,description,prix,utilisateur);
        for (Categorie c: categories) {
            if(_categorieRepository.existsById(c.getId())){
                annonce.addCategories(c);
            }
        }
        if(_annonceRepository.save(annonce) !=null){
            for(MultipartFile img : images) {
                Image image =new Image();
                image.setUrl(_uploadService.store(img));
                image.setAnnonce(annonce);
                _imageRepository.save(image);
            }
            return annonce;
        }
        return null;
    }

    public boolean deleteAnnonce(int id) throws Exception {
        Annonce annonce = _annonceRepository.findById(id).get();
        if(annonce != null){
            _annonceRepository.delete(annonce);
            return true;
        }
        throw new Exception("Aucune annonce avec cet id");
    }

    public boolean updateAnnonce(Annonce annonce) throws Exception {
        _annonceRepository.save(annonce);
        return annonce.getId()>0;
    }

    public List<Annonce> getAllAnnonces(){
        return (List<Annonce>) _annonceRepository.findAll();
    }

    public List<Annonce> getAnnonceByUtilisateur(Utilisateur utilisateur){
        return (List<Annonce>) _annonceRepository.findByUtilisateur(utilisateur);
    }

    public Annonce findById(int id){
        return _annonceRepository.findById(id).get();
    }


}
