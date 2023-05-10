package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Lieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LieuDAO extends BaseDAO<Lieu> {


    public LieuDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Lieu element) throws SQLException {
        request = "INSERT INTO lieu(nom,adresse,capacite) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getNom());
        statement.setString(2,element.getAdresse());
        statement.setInt(3,element.getCapacite());
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows == 1;
    }

    @Override
    public boolean update(Lieu element) throws SQLException{
        request = "UPDATE lieu SET nom = ?, adresse = ?, capacite = ? WHERE id = ?";
        statement=_connection.prepareStatement(request);
        statement.setString(1,element.getNom());
        statement.setString(2,element.getAdresse());
        statement.setInt(3,element.getCapacite());
        statement.setInt(4,element.getId());
        int rows = statement.executeUpdate();
        return rows == 1;
    }

    @Override
    public boolean delete(Lieu element) throws SQLException {
        request = "DELETE FROM lieu WHERE id =?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int rows = statement.executeUpdate();
        return rows ==1;
    }

    @Override
    public Lieu get(int id) throws SQLException {
        Lieu lieu = null;
        request = "SELECT * FROM lieu WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            lieu =  new Lieu(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("adresse"),
                    resultSet.getInt("capacite"));
        }
        return lieu;
    }

    @Override
    public List<Lieu> get() throws SQLException {
        List<Lieu> lieux = new ArrayList<>();
        request = "SELECT * FROM lieu";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            lieux.add(new Lieu(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("adresse"),
                    resultSet.getInt("capacite")));
        }
        return lieux;
    }
}
