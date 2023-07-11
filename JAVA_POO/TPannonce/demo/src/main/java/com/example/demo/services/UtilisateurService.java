package com.example.demo.services;

import com.example.demo.entities.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private HttpSession _httpSession;

    @Autowired
    private UtilisateurRepository _utilisateurRepository;

    public boolean createUser(String mail,String mdp) throws Exception{
        if(mail == null || mdp == null){
            throw new Exception("Remplir tout les champs");
        }
        Utilisateur utilisateur = Utilisateur.builder().mail(mail).mdp(mdp).actif(true).statut(false).build();
        if(_utilisateurRepository.save(utilisateur) != null){
            return true;
        }
        return false;
    }

    public boolean updateStatut(int id) throws Exception{
        Utilisateur utilisateur = _utilisateurRepository.findById(id).get();
        if(utilisateur != null){
            utilisateur.setStatut(!utilisateur.getStatut());
            _utilisateurRepository.save(utilisateur);
            return true;
        }
        throw new Exception("Aucune personne avec cet ID");
    }

    public boolean updateActif(int id) throws Exception{
        Utilisateur utilisateur = _utilisateurRepository.findById(id).get();
        if(utilisateur != null){
            utilisateur.setActif(!utilisateur.getActif());
            _utilisateurRepository.save(utilisateur);
            return true;
        }
        throw new Exception("Aucune personne avec cet ID");
    }

    public boolean deleteUser(int id) throws Exception{
        Utilisateur utilisateur = _utilisateurRepository.findById(id).get();
        if(utilisateur != null){
            _utilisateurRepository.delete(utilisateur);
            return true;
        }
        throw new Exception("Aucune personne avec cet ID");
    }

    public boolean login(String email, String mdp){
        Utilisateur utilisateur = _utilisateurRepository.findByMail(email);
        if(utilisateur != null && utilisateur.getMdp().equals(mdp)){
            _httpSession.setAttribute("isLogged","OK");
            _httpSession.setAttribute("idUtilisateur" , 2);
            return true;
        }
        return false;
    }

    public boolean isLogged(){
        try {
            String estConnecte = _httpSession.getAttribute("isLogged").toString();
            return estConnecte.equals("OK");
        }catch (Exception e){
            return false;
        }
    }

    public Utilisateur findById(int id){
            return _utilisateurRepository.findById(id).get();
    }

}
