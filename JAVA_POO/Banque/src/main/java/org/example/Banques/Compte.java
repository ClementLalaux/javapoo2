package org.example.Banques;

import java.sql.*;
import java.util.List;

public class Compte {

    int id;
    int code;
    float solde;
    private int clientId;

    private List<Operation> operations;
    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public Compte(int code, float solde,int clientId) {
        this.code = code;
        this.solde = solde;
        this.clientId = clientId;
    }

    public Compte(int id,int code,float solde,int clientId) {
        this(code, solde,clientId);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void versement(float vers) throws SQLException {
        solde = solde+vers;
        update(getSolde());
    }

    public void retrait(float ret) throws SQLException {
        if(solde>=ret){
            solde = this.solde-ret;
        }
        update(getSolde());
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO compte (code,solde,client_id) values (?,?,?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, getCode());
        statement.setFloat(2, getSolde());
        statement.setInt(3,getClientId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

    public boolean update(float solde) throws SQLException {
        request = "UPDATE compte SET solde = ? WHERE id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setFloat(1, getSolde());
        statement.setInt(2, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public static Compte getById(int id) throws SQLException {
        Compte compte = null;
        request = "SELECT * FROM compte where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            compte = new Compte(resultSet.getInt("id"),
                    resultSet.getInt("code"),
                    resultSet.getInt("solde"),
                    resultSet.getInt("client_id"));
        }
        return compte;
    }

}
