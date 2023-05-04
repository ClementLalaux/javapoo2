package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Vente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VenteDAO extends BaseDAO<Vente>{

    public VenteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Vente element) throws ExecutionControl.NotImplementedException, SQLException {
        return false;
    }

    @Override
    public List<Vente> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        return null;
    }

    public List<Vente> getAllById(int id) throws SQLException {
        return null;
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
