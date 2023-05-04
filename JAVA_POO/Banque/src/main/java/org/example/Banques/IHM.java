package org.example.Banques;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    String choix;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        do{
            menu();
            choix = scanner.nextLine();
            switch (choix){
                case "1":
                    addContactAction();
                    break;
                case "2":
                    break;
            }

        }while (!choix.equals("0"));
    }

    private void menu() {
        System.out.println("1 - Ajouter un client");
        System.out.println("2 - Modifier un client ");
    }

    private void addContactAction() {
        System.out.print("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        Client client = new Client(firstName, lastName);
        try {
            if(client.save()) {
                System.out.println("Contact ajouté "+ client.getId());
                addComptesAction(client.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addComptesAction(int clientId) {
        do {
            System.out.print("Ajouter un compte ? (O/N) ");
            choix = scanner.nextLine();
            if(choix.equals("O")) {
                System.out.print("Merci de saisir le code : ");
                int code = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Merci de saisir le solde : ");
                Float solde = scanner.nextFloat();
                scanner.nextLine();
                Compte compte = new Compte(code,solde,clientId);
                try {
                    if(compte.save()) {
                        System.out.println("Compte ajouté");
                        addOperationsAction(compte.getId());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }while (!choix.equals("N"));
    }

    private void addOperationsAction(int compteId) {
        do {
            System.out.print("Ajouter une opération ? (O/N) ");
            choix = scanner.nextLine();
            if(choix.equals("O")) {
                System.out.print("Merci de saisir le nom : ");
                String nomOperation = scanner.nextLine();
                System.out.print("Merci de saisir le montant : ");
                float montant = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Merci de saisir 0 pour un retrait et 1 pour un ajout");
                int statutInt = scanner.nextInt();
                RetraitOuAjout retraitOuAjout = RetraitOuAjout.fromInteger(statutInt);
                Operation operation = new Operation(nomOperation,montant,compteId,retraitOuAjout);
                System.out.println(operation.getMontant());
                try {
                    Compte compte = Compte.getById(compteId);
                    if(operation.save()) {
                        if(retraitOuAjout.equals(RetraitOuAjout.AJOUT)){
                            compte.versement(montant);
                            System.out.println("operation ajouté");
                        } else if(retraitOuAjout.equals(RetraitOuAjout.RETRAIT) && compte.getSolde()>montant){
                            compte.retrait(montant);
                            System.out.println("operation retrait");
                        } else {
                            System.out.println("operation annulé");
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }while (!choix.equals("N"));
    }



}
