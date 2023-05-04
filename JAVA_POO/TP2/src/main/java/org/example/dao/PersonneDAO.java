package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Personne;
import org.example.model.Voiture;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO extends BaseDAO<Personne> {

    public PersonneDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Personne element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "INSERT INTO personne (nom,prenom,age) values (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getNom());
        statement.setString(2, element.getPrenom());
        statement.setInt(3, element.getAge());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1)) ;
        }
        return nbRow == 1;
    }

    @Override
    public List<Personne> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        List<Personne> personnes = new ArrayList<>();
        request = "SELECT * FROM personne";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Personne personne = new Personne(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getInt("age")
            );
            personnes.add(personne);
        }
        return personnes;
    }

    @Override
    public boolean update(Personne element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "UPDATE voiture set prix = ? where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setFloat(1, element.getPrix());
        statement.setInt(2, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Personne element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "DELETE FROM voiture where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }