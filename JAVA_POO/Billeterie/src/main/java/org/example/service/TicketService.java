package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.DataBaseManager;
import org.example.dao.ClientDAO;
import org.example.dao.EvenementDAO;
import org.example.dao.TicketDAO;
import org.example.entity.Client;
import org.example.entity.Evenement;
import org.example.entity.Lieu;
import org.example.entity.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService {

    private Connection connection;
    private TicketDAO ticketDAO;
    private EvenementDAO evenementDAO;
    private ClientDAO clientDAO;

    public TicketService(){
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            ticketDAO = new TicketDAO(connection);
            clientDAO = new ClientDAO(connection);
            evenementDAO = new EvenementDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createSale(int nombreTickets,int idEvenement, int idClient) {
        try {
            Evenement evenement = evenementDAO.get(idEvenement);
            Client client = clientDAO.get(idClient);
            if(evenement != null && client != null) {
                Ticket ticket = new Ticket(nombreTickets,evenement, client);
                if(ticketDAO.save(ticket)) {
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

    public Ticket getTicket(int id) {
        try {
            return ticketDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ticket> getTicket() {
        try {
            return ticketDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTicket(int id, int nombreTickets,int idEvenement, int idClient ){
        try {
            Ticket ticket = getTicket(id);
            ticket.setNombre_tickets(nombreTickets);
            ticket.setEvenement(evenementDAO.get(idEvenement));
            ticket.setClient(clientDAO.get(idClient));
            if(ticketDAO.update(ticket)){
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



    public boolean deleteTicket(int id) {
        Ticket ticket = null;
        try {
            ticket = ticketDAO.get(id);
            if(ticket != null) {
                return ticketDAO.delete(ticket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
