package org.example.service;

import org.example.DataBaseManager;
import org.example.dao.EvenementDAO;
import org.example.dao.LieuDAO;
import org.example.entity.Evenement;
import org.example.entity.Lieu;
import org.example.entity.Ticket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EvenementService {

    private Connection connection;
    private EvenementDAO evenementDAO;
    private LieuDAO lieuDAO;

    public EvenementService(){
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            lieuDAO = new LieuDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createEvenement(String nom, Date date, double prix, int lieuId) {
        try {
            Lieu lieu = lieuDAO.get(lieuId);
            if(lieu != null) {
                Evenement evenement = new Evenement(nom,date,prix,lieu);
                if(evenementDAO.save(evenement)) {
                    connection.commit();
                    return true;
                }
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return  false;
    }

    public Evenement getEvenement(int id) {
        try {
            return evenementDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Evenement> getEvenement() {
        try {
            return evenementDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEvenement(int id, String nom, Date dateEvenement, double prix, int idLieu) {
        try {
            Evenement evenement = getEvenement(id);
            evenement.setNom(nom);
            evenement.setDate_evenement(dateEvenement);
            evenement.setPrix(prix);
            evenement.setLieu_evenement(lieuDAO.get(idLieu));
            if(evenementDAO.update(evenement)){
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return false;
    }

    public boolean deleteEvenement(int id) {
        Evenement evenement = null;
        try {
            evenement = evenementDAO.get(id);
            if(evenement != null) {
                return evenementDAO.delete(evenement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
