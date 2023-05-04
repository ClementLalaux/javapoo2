package org.example.Banques;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    private static final String URI = "jdbc:mysql://localhost:3306/banque";
    private static final String USER = "root";
    private static final String PASSWORD = "Nrwp95qh&";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}