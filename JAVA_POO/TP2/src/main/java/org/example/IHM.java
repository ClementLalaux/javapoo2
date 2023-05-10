package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.PersonneDAO;
import org.example.dao.VenteDAO;
import org.example.dao.VoitureDAO;
import org.example.model.Personne;
import org.example.model.Vente;
import org.example.model.Voiture;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    String choix;

    private PersonneDAO personneDAO;
    private VenteDAO venteDAO;
    private VoitureDAO voitureDAO;

    private Connection connection;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException, ExecutionControl.NotImplementedException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createPersonneAction();
                    break;
                case "2":
                    createVoitureAction();
                    break;
                case "3" :
                    displayPersonneAction();
                case "4":
                    displayVoitureAction();
                case "5":
                    createVenteAction();
                case "6":
                    displayVenteAction();
                case "7":
                    displayVenteByPersonneAction();

            }
        } while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("1 - Ajouter personne ");
        System.out.println("2 - Ajouter voiture");
        System.out.println("3 - Trouver une personne grâce à son ID");
        System.out.println("4 - Trouver une voiture grâce à son ID");
        System.out.println("5 - Ajouter une vente");
        System.out.println("6 - Afficher toutes les ventes");
        System.out.println("7 - Afficher toutes les ventes d'une personne");
    }

    private Personne createPersonneAction() throws SQLException, ExecutionControl.NotImplementedException {
        Personne personne = null;
        System.out.println("Merci de saisir un nom");
        String nom = scanner.nextLine();
        System.out.println("Merci de saisir un prenom");
        String prenom = scanner.nextLine();
        System.out.println("Merci de saisir un prenom");
        int age = scanner.nextInt();
        scanner.nextLine();
        personne = new Personne(prenom,nom,age);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            personneDAO = new PersonneDAO(connection);
            if(personneDAO.save(personne)){
                System.out.println("Personne" + personne.getId() + " a été crée");
            } else {
                personne = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            personne = null;
        }
        return personne;
    }

    private Voiture createVoitureAction() throws SQLException, ExecutionControl.NotImplementedException {
        Voiture voiture = null;
        System.out.println("Merci de saisir un nom");
        String nom = scanner.nextLine();
        System.out.println("Merci de saisir une année");
        int annee = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir une puissance de cheveaux");
        int puissance = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir un prix");
        float prix = scanner.nextFloat();
        scanner.nextLine();
        voiture = new Voiture(nom,annee,puissance,prix);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            voitureDAO = new VoitureDAO(connection);
            if(voitureDAO.save(voiture)){
                System.out.println("Personne" + voiture.getId() + " a été crée");
            } else {
                voiture = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            voiture = null;
        }
        return voiture;
    }

    private Personne displayPersonneAction(){
        Personne personne = null;
        System.out.print("Merci de saisir l'id de la personne: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            personneDAO = new PersonneDAO(connection);
            personne = personneDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(personne != null) {
            System.out.println(personne);
        }
        return personne;
    }

    private Voiture displayVoitureAction(){
        Voiture voiture = null;
        System.out.print("Merci de saisir l'id de la voiture: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            voitureDAO = new VoitureDAO(connection);
            voiture = voitureDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(voiture != null) {
            System.out.println(voiture);
        }
        return voiture;
    }



    private Vente createVenteAction(){
        Vente vente = null;
        System.out.print("Merci de saisir l'id de la voiture: ");
        int idVoiture = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Merci de saisir l'id de la voiture: ");
        int idPersonne = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez la date d'achat");
        String dateVente = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse(dateVente);
            vente = new Vente(idVoiture,idPersonne,date);
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            venteDAO = new VenteDAO(connection);
            if(voitureDAO.getById(idVoiture) != null && personneDAO.getById(idPersonne) != null && venteDAO.save(vente)){
                System.out.println("Vente " + vente.getId());
                connection.commit();
            } else {
                vente = null;
            }
        } catch (ParseException e) {
            System.out.println("Format de date invalide");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vente = null;
        }
        return vente;
    }

    private List<Vente> displayVenteAction(){
        List<Vente> ventes = new ArrayList<>();
        try {
            connection = new DataBaseManager().getConnection();
            venteDAO = new VenteDAO(connection);
            ventes = venteDAO.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        while (ventes != null) {
            System.out.println(ventes);
        }
        return ventes;
    }

    private List<Vente> displayVenteByPersonneAction(){
        List<Vente> ventes = new ArrayList<>();
        System.out.print("Merci de saisir l'id de la personne: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            venteDAO = new VenteDAO(connection);
            ventes = venteDAO.getByIdPersonne(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(ventes != null) {
            System.out.println(ventes);
        }
        return ventes;
    }

}
