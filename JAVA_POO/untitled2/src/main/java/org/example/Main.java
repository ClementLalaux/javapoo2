package org.example;

import org.example.util.DataBaseManager;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBaseManager dataBaseManager = new DataBaseManager();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Connection connection = dataBaseManager.getConnection();
            System.out.println("Entrez un nom");
            String nom = scanner.nextLine();
            System.out.println("Entrez un prenom");
            String prenom = scanner.nextLine();
            System.out.println("Entrez un numero de class");
            Integer nb_classe = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Entrez une date");
            String date_diplome = scanner.nextLine();

            try {
                Date date_formatter = formatter.parse(date_diplome);

                java.sql.Date sqlDate = new java.sql.Date(date_formatter.getTime());

                String ajout = "INSERT INTO etudiant (nom,prenom,nb_classe,date_diplome) VALUES (?,?,?,?)";

                PreparedStatement preparedStatementAjout = connection.prepareStatement(ajout);
                preparedStatementAjout.setString(1,nom);
                preparedStatementAjout.setString(2,prenom);
                preparedStatementAjout.setInt(3,nb_classe);
                preparedStatementAjout.setDate(4, sqlDate);

                //preparedStatementAjout.execute();

            } catch (Exception e ){
                System.out.println(e.getMessage());
            }



            String request = "SELECT * FROM etudiant";

            String request2 = "SELECT * FROM etudiant WHERE nb_classe = 2";

            String request3 = "DELETE FROM etudiant WHERE idetudiant = 1";

            PreparedStatement preparedStatement = connection.prepareStatement(request3);

            preparedStatement.execute();

            /*ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("nom"));
            }*/

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}