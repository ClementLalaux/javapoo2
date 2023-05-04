package org.example.Banques;

import java.sql.*;
import java.util.List;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private List<Compte> comptes;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(int id,String firstName, String lastName) {
        this(firstName,lastName);
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO client (first_name, last_name) values (?, ?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getFirstName());
        statement.setString(2, getLastName());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
