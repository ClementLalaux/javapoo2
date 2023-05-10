package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO<Client>{

    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client(nom,prenom,email) VALUE (?,?,?)";
        statement= _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getNom());
        statement.setString(2,element.getPrenom());
        statement.setString(3,element.getEmail());
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows ==1;
    }

    @Override
    public boolean update(Client element) throws SQLException{
        request = "UPDATE client SET nom = ?, prenom = ?,email = ? WHERE id =?";
        statement = _connection.prepareStatement(request);
        statement.setString(1,element.getNom());
        statement.setString(2,element.getPrenom());
        statement.setString(3,element.getEmail());
        statement.setInt(4,element.getId());
        int rows = statement.executeUpdate();
        return rows ==1;
    }

    @Override
    public boolean delete(Client element) throws SQLException {
        request = "DELETE FROM client WHERE id =?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int rows = statement.executeUpdate();
        return rows ==1;
    }

    @Override
    public Client get(int id) throws SQLException {
        Client client = null;
        request = "SELECT * FROM client WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            client = new Client(resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("email"));
        }
        return client;
    }

    @Override
    public List<Client> get() throws SQLException {
        List<Client> clients = new ArrayList<>();
        request = "SELECT * FROM client";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            clients.add(new Client(resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("email")));
        }
        return clients;
    }
}
