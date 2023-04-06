package org.example.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);
    public void lancer(){
        List<Chambre> chambres = new ArrayList<Chambre>();
        for (int i = 0; i < 20; i++) {
            Chambre myChambre = new Chambre(i,50,2);
            chambres.add(myChambre);
        }
        Hotel hotel = new Hotel("Mon hotel",chambres);
    }





    public void ajouterClient(Hotel hotel){
        System.out.println("Entrez un nom");
        String nom = sc.next();
        System.out.println("Entrez un prénom");
        String prenom = sc.next();
        System.out.println("Entrez un telephone");
        String telephone = sc.next();

        Client client = new Client(nom,prenom,telephone);

        hotel.setClients(client);

    }

    public void voirListe(Hotel hotel){
        for (Client a : hotel.getClients()) {
            System.out.println("Client id : " + a.getId() + " , nom : " + a.getNom() + " , prénom : " + a.getPrenom());
        }
    }


    public void ajouterReservation(Hotel hotel){
        String tel;

        Boolean test = false;
        do{
            System.out.println("Entrez numero de telephone");
            tel=sc.next();

            for (Client a : hotel.getClients()) {
                if(a.getNumero() == tel){
                    test = true;
                    System.out.println("Entrez le nombre de personne ");

                    int nbOccu = sc.nextInt();

                    for (Chambre b :hotel.getChambres()) {
                        if(!b.getOccupe() && b.getCapacite()>= nbOccu){
                            Reservation reservation = new Reservation(tel,true,a,b);
                            hotel.setReservations(reservation);
                            b.setOccupe(true);
                            test = true;
                            break;
                        }
                    }
                }
            }

        }while (test == false || tel == "-1");

    }



}

