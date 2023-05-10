package org.example;

import org.example.service.ClientService;
import org.example.service.EvenementService;
import org.example.service.LieuService;
import org.example.service.TicketService;

import java.util.Scanner;

public class IHM {

    private Scanner sc;
    private String choix;
    private ClientService clientService;
    private EvenementService evenementService;
    private LieuService lieuService;
    private TicketService ticketService;

    public void start(){
        sc = new Scanner(System.in);

        do {
            menu();
            choix = sc.nextLine();
            switch (choix) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":


                    break;
                case "8":


                    break;
                case "9":


                    break;
                case "10":


                    break;
                case "11":

                    break;

            }
        } while (!choix.equals("0"));

    }

    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP 2 VOITURE ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1 - Enregistrer la voiture ");
        System.out.println("2 - Lister toutes les voitures ");
        System.out.println("3 - Supprimer la voiture ");
        System.out.println("4 - Modifier une voiture ");
        System.out.println("5 - Inscrire un acheteur");
        System.out.println("6 - Lister toutes les acheteur");
        System.out.println("7 - Supprimer une personne");
        System.out.println("8 - Modifier un acheteur");
        System.out.println("9 - Faire la vente");
        System.out.println("10 - Afficher les ventes de voiture ");
        System.out.println("11 - Afficher la liste des ventes d'un véhicule pour un acheteur");
        System.out.println("12 - Quitter");
    }

}
