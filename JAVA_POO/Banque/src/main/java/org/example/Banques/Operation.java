package org.example.Banques;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {

    private int id;
    private String nomOperation;
    private float montant;
    private int compteId;
    private RetraitOuAjout retraitOuAjout;
    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public String getNomOperation() {
        return nomOperation;
    }

    public void setNomOperation(String nomOperation) {
        this.nomOperation = nomOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getCompteId() {
        return compteId;
    }

    public void setCompteId(int compteId) {
        this.compteId = compteId;
    }

    public RetraitOuAjout getRetraitOuAjout() {
        return retraitOuAjout;
    }

    public void setRetraitOuAjout(RetraitOuAjout retraitOuAjout) {
        this.retraitOuAjout = retraitOuAjout;
    }

    public Operation(String nomOperation, float montant, int compteId,RetraitOuAjout retraitOuAjout) {
        this.nomOperation = nomOperation;
        this.montant = montant;
        this.compteId = compteId;
        this.retraitOuAjout = retraitOuAjout;
    }

    public Operation(int id,String nomOperation, float montant, int compteId,RetraitOuAjout retraitOuAjout) {
        this(nomOperation, montant, compteId,retraitOuAjout);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO operation (nom_operation,montant,compte_id,statut) values (?,?,?,?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,getNomOperation());
        statement.setFloat(2, getMontant());
        statement.setInt(3, getCompteId());
        statement.setInt(4,getRetraitOuAjout().ordinal());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

/*    public static List<Operation> getOperationByCompteId(int compteId) throws SQLException {
        List<Operation> results = new ArrayList<>();
        request = "SELECT * FROM operation where compte_id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, compteId);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Operation operation = new Operation(resultSet.getString("nom_operation"),
                    resultSet.getFloat("montant"),
                    resultSet.getInt("compte_id"));
            results.add(operation);
        }
        return results;
    }*/

}
