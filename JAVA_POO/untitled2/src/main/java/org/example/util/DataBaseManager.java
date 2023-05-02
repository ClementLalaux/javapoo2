package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String url = "jdbc:mysql://localhost:3306/personne";
    private static final String user = "root";

    private static final String password = "Nrwp95qh&";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}
