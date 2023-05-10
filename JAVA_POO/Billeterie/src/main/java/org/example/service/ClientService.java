package org.example.service;

import org.example.DataBaseManager;
import org.example.dao.ClientDAO;
import org.example.entity.Client;
import org.example.entity.Evenement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientDAO clientDAO;
    private Connection connection;

    public ClientService(){
        try {
            connection = new DataBaseManager().getConnection();
            clientDAO = new ClientDAO(connection);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean createClient(String nom, String prenom, String email) {
        Client client = new Client(nom, prenom, email);
        try {
            if(clientDAO.save(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateClient(int id, String nom, String prenom, String email) {
        try {
            Client client = getClient(id);
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setEmail(email);
            if(clientDAO.update(client)){
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

    public Client getClient(int id) {
        try {
            return clientDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(int id) {
        Client client = null;
        try {
            client = clientDAO.get(id);
            if(client != null) {
                return clientDAO.delete(client);
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

    public List<Client> getAllClient() {
        try {
            return clientDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
