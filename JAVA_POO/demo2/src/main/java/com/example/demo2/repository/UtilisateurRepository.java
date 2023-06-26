package com.example.demo2.repository;

import com.example.demo2.entity.Utilisateur;
import org.hibernate.Session;

import java.util.List;

public class UtilisateurRepository extends Repository<Utilisateur>{

    public UtilisateurRepository(Session session){
        super(session);
    }

    @Override
    public Utilisateur findById(int id) {
        return (Utilisateur) _session.get(Utilisateur.class,id);
    }

    @Override
    public List<Utilisateur> findAll(){
        return _session.createQuery("from Utilisateur ").list();
    }
}
