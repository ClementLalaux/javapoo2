package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Evenement;
import org.example.entity.Lieu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO extends  BaseDAO<Evenement>{


    public EvenementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Evenement element) throws SQLException {
        request = "INSERT INTO evenement(nom, date_evenement, prix, lieu_id) VALUE (?,?,?,?)";
        statement= _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getNom());
        statement.setDate(2,(Date) element.getDate_evenement());
        statement.setDouble(3, element.getPrix());
        statement.setInt(4,element.getLieu_evenement().getId());
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows ==1;
    }

    @Override
    public boolean update(Evenement element) throws SQLException{
        request = "UPDATE evenement set nom = ?, date_evenement = ?, prix = ?, lieu_id = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getNom());
        statement.setDate(2, (Date) element.getDate_evenement());
        statement.setDouble(3,element.getPrix());
        statement.setInt(4,element.getLieu_evenement().getId());
        statement.setInt(5,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(Evenement element) throws SQLException {
        request = "delete from evenement where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public Evenement get(int id) throws SQLException {
        Evenement evenement = null;
        request = "select e.id as e_id, e.nom as e_nom, e.date_evenement, e.prix, e.lieu_id, l.id as l_id, l.nom as l_nom, l.adresse, l.capacite from evenement AS e inner join lieu as l on evenement.lieu_id = lieu.id where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            evenement = new Evenement(resultSet.getInt("e_id"),
                    resultSet.getString("e_nom"),
                    resultSet.getDate("date_evenement"),
                    resultSet.getInt("prix"));

            evenement.setLieu_evenement(new Lieu(
                    resultSet.getInt("l_id"),
                    resultSet.getString("l_nom"),
                    resultSet.getString("adresse"),
                    resultSet.getInt("capacite")
            ));
        }
        return evenement;
    }

    @Override
    public List<Evenement> get() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        request = "select e.id as e_id, e.nom as e_nom, e.date_evenement, e.prix, e.lieu_id, l.id as l_id, l.nom as l_nom, l.adresse, l.capacite from evenement AS e inner join lieu as l on evenement.lieu_id = lieu.id";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Evenement evenement = null;
            evenement = new Evenement(resultSet.getInt("e_id"),
                    resultSet.getString("e_nom"),
                    resultSet.getDate("date_evenement"),
                    resultSet.getInt("prix"));

            evenement.setLieu_evenement(new Lieu(
                    resultSet.getInt("l_id"),
                    resultSet.getString("l_nom"),
                    resultSet.getString("adresse"),
                    resultSet.getInt("capacite")
            ));
            evenements.add(evenement);
        }
        return evenements;
    }
}
