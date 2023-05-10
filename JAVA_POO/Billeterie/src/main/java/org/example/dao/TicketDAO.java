package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Client;
import org.example.entity.Evenement;
import org.example.entity.Lieu;
import org.example.entity.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends BaseDAO<Ticket>{

    public TicketDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ticket element) throws SQLException {
        request = "INSERT INTO sale(nombre_tickets, id_evenement, id_client) VALUE (?,?,?)";
        statement= _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getNombre_tickets());
        statement.setInt(2,element.getEvenement().getId());
        statement.setInt(3, element.getClient().getId());
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows ==1;
    }


    @Override
    public boolean update(Ticket element) throws SQLException{
        request = "UPDATE personne set nombre_tickets = ?, id_evenement = ?, id_client = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getNombre_tickets());
        statement.setInt(2,element.getEvenement().getId());
        statement.setInt(3,element.getClient().getId());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(Ticket element) throws SQLException{
        request = "delete from ticket where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public Ticket get(int id) throws SQLException {
        Ticket ticket = null;
        request = "SELECT t.id as t_id, t.nombre_tickets, t.id_evenement, t.id_client, e.id as e_id, e.nom as e_nom, e.date_evenement, e.prix, e.lieu_id, c.id as c_id, c.nom as c_nom, c.prenom, c.email, l.id as l_id, l.nom as l_nom, l.adresse, l.capacite FROM ticket as t inner join evenement as e on t.id_evenement = e.id inner join client as c on t.id_client = c.id inner join lieu as l on e.lieu_id = l.id where t.id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Lieu lieu = new Lieu(resultSet.getInt("l_id"),resultSet.getString("l_nom"),resultSet.getString("adresse"),resultSet.getInt("capacite"));
            ticket = new Ticket(id, resultSet.getInt("nombre_tickets"));
            ticket.setClient(new Client(resultSet.getInt("c_id"),
                    resultSet.getString("c_nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("email")));
            ticket.setEvenement(new Evenement(resultSet.getInt("e_id"),
                    resultSet.getString("e_nom"),
                    resultSet.getDate("date_evenement"),
                    resultSet.getDouble("prix"),
                    lieu));
        }
        return ticket;
    }

    @Override
    public List<Ticket> get() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();

        request = "SELECT t.id as t_id, t.nombre_tickets, t.id_evenement, t.id_client, e.id as e_id, e.nom as e_nom, e.date_evenement, e.prix, e.lieu_id, c.id as c_id, c.nom as c_nom, c.prenom, c.email, l.id as l_id, l.nom as l_nom, l.adresse, l.capacite FROM ticket as t inner join evenement as e on t.id_evenement = e.id inner join client as c on t.id_client = c.id inner join lieu as l on e.lieu_id = l.id";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Ticket ticket = null;
            Lieu lieu = new Lieu(resultSet.getInt("l_id"),resultSet.getString("l_nom"),resultSet.getString("adresse"),resultSet.getInt("capacite"));
            ticket = new Ticket(resultSet.getInt("t_id"), resultSet.getInt("nombre_tickets"));
            ticket.setClient(new Client(resultSet.getInt("c_id"),
                    resultSet.getString("c_nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("email")));
            ticket.setEvenement(new Evenement(resultSet.getInt("e_id"),
                    resultSet.getString("e_nom"),
                    resultSet.getDate("date_evenement"),
                    resultSet.getDouble("prix"),
                    lieu));
            tickets.add(ticket);
        }
        return tickets;
    }
}
