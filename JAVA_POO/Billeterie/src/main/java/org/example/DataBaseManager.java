package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    private static final String URI = "jdbc:mysql://localhost:3306/billeterie";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static DataBaseManager instance = null;

    private DataBaseManager(){

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }

    public static DataBaseManager getInstance() {
        if(instance == null){
            instance = new DataBaseManager();
        }
        return instance;
    }
}
