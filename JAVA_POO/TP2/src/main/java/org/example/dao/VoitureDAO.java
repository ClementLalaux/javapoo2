package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Voiture;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO extends BaseDAO<Voiture> {

    public VoitureDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Voiture element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "INSERT INTO voiture (nom,annee,puissance_cheveaux,prix) values (?,?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getNom());
        statement.setInt(2, element.getAnnee());
        statement.setInt(3, element.getPuissanceCheveaux());
        statement.setFloat(4, element.getPrix());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1)) ;
        }
        return nbRow == 1;
    }

    @Override
    public List<Voiture> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        List<Voiture> voitures = new ArrayList<>();
        request = "SELECT * FROM voiture";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
           Voiture voiture = new Voiture(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getInt("annee"),
                    resultSet.getInt("puissance_cheveaux"),
                    resultSet.getFloat("prix")
            );
           voitures.add(voiture);
        }
        return voitures;
    }

    @Override
    public boolean update(Voiture element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "UPDATE voiture set prix = ? where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setFloat(1, element.getPrix());
        statement.setInt(2, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Voiture element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "DELETE FROM voiture where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
}
