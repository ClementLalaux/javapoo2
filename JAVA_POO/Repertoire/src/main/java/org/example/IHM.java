package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    private Scanner scanner;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        String choix;
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    addInscritAction();
                    break;
                case "2":
                    getAllInscritAction();
                    break;
                case "3" :
                    getInscritByTelephoneAction();
                    break;
                case "4":
                    deleteInscritAction();
                    break;
            }
        }while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }

    private void addInscritAction()  {
        System.out.println("**** Ajouter un étudiant ****");
        System.out.print("Merci de saisir le nom : ");
        String nom = scanner.nextLine();
        System.out.print("Merci de saisir le prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Merci de saisir le téléphone : ");
        String telephone = scanner.nextLine();
        Inscrit inscrit = new Inscrit(nom, prenom, telephone);
        try {
            if(inscrit.ajouter()) {
                System.out.println("Etudiant ajouté "+ inscrit.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getAllInscritAction() {
        try {
            Inscrit.getAll().forEach(e -> System.out.println(e));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteInscritAction() {
        System.out.print("Merci de saisir l'id de l'inscrit : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Inscrit inscrit = Inscrit.getById(id);
            if(inscrit != null) {
                if(inscrit.delete()) {
                    System.out.println("Contact supprimé");
                }
            }
            else {
                System.out.println("Aucun Contact avec cet id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getInscritByTelephoneAction() {
        try {
            System.out.print("Merci de saisir le numéro : ");
            String tel = scanner.nextLine();
            Inscrit.getByNumber(tel).forEach(e -> System.out.println(e.toString()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

