import java.sql.*;

public class Demo {

    public static void main(String[] args) {
        // Nom du driver pour acceder a la base de donnees.
        // Lire la documentation associee a sa base de donnees pour le connaitre
        final String dbDriver = "com.mysql.cj.jdbc.Driver"; // Nom long d'une classe
        // URL d'access a la base de donnees.
        final String dbUrl = "jdbc:mysql://localhost:3306/banque"; // banque est le nom de la base
        // Login d'access a la base de donnees.
        final String dbLogin = "root"; // Ou "SA" en HSQL
        // Mot de passe d'access a la base de donnees.
        final String dbPwd = ""; // Ou "" en HSQL
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement request = null;
        ResultSet resultat = null;

        try {
            connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
            request = connection.createStatement();
            resultat = request.executeQuery("SELECT * from utilisateur");
            while (resultat.next()) {
                String date = resultat.getString("dateDeNaissance");
                System.out.println(date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (request != null) {
                try {
                    request.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
