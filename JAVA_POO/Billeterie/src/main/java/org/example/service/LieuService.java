package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.DataBaseManager;
import org.example.dao.LieuDAO;
import org.example.entity.Lieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LieuService {

    private Connection connection;
    private LieuDAO lieuDAO;

    public LieuService(){
        try {
            connection = new DataBaseManager().getConnection();
            lieuDAO = new LieuDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createLieu(String nom, String adresse, int capacite){
        Lieu lieu = new Lieu(nom,adresse,capacite);
        try {
            if(lieuDAO.save(lieu)){
                return true;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateLieu(int id, String nom, String adresse, int capacite){
        try {
            Lieu lieu = getLieu(id);
            lieu.setNom(nom);
            lieu.setAdresse(adresse);
            lieu.setCapacite(capacite);
            if(lieuDAO.update(lieu)){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Lieu getLieu(int id) {
        try {
            return lieuDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteLieu(int id) {
        Lieu lieu = null;
        try {
            lieu = lieuDAO.get(id);
            if(lieu != null) {
                return lieuDAO.delete(lieu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Lieu> getAllLieux() {
        try {
            return lieuDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
