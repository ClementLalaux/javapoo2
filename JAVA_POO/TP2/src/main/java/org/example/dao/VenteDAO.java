package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Personne;
import org.example.model.Vente;
import org.example.model.Voiture;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VenteDAO extends BaseDAO<Vente>{

    public VenteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Vente element) throws SQLException {
        request = "INSERT INTO vente (voiture_id, personne_id, date_vente) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getVoiture_id());
        statement.setInt(2,element.getPersonne_id());
        statement.setDate(3, (Date) element.getDate_vente());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }


    @Override
    public List<Vente> getAll() throws SQLException {
        List<Vente> ventes = new ArrayList<>();
        request = "SELECT * FROM vente";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Vente vente = new Vente(resultSet.getInt("id"),
                    resultSet.getInt("voiture_id"),
                    resultSet.getInt("personne_id"),
                    resultSet.getDate("date_vente")
            );
            ventes.add(vente);
        }
        return ventes;
    }

    @Override
    public Vente getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        throw new ExecutionControl.NotImplementedException("update");
    }

    public List<Vente> getByIdPersonne(int id) throws  SQLException {
        List<Vente> ventes = new ArrayList<>();
        request = "SELECT * FROM vente where personne_id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Vente vente = new Vente(resultSet.getInt("id"),
                    resultSet.getInt("voiture_id"),
                    resultSet.getInt("personne_id"),
                    resultSet.getDate("date_vente")
            );
            ventes.add(vente);
        }
        return ventes;
    }

    @Override
    public boolean update(Vente element) throws ExecutionControl.NotImplementedException, SQLException {
        throw new ExecutionControl.NotImplementedException("update");
    }

    @Override
    public boolean delete(Vente element) throws ExecutionControl.NotImplementedException, SQLException {
        throw new ExecutionControl.NotImplementedException("delete");
    }
}
