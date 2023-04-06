package org.example.Exercice4;

public class Salarie {
    public static int nbSalarie;
    public int matricule;
    public String categorie;
    public String service;
    public String nom;

    public float somme = 0;
    public float salaire;

    public Salarie(int matricule, String categorie, String service, String nom, float salaire) {
        this.matricule = ++nbSalarie;
        this.categorie = categorie;
        this.service = service;
        this.nom = nom;
        this.salaire = salaire;
    }

    public void AfficherSalaire(){
        System.out.println("Le salaire est de " + salaire + " euros");
    }

    public float SommeSalaire(int nbMois){
        for (int i = 0; i < nbMois; i++) {
            somme = somme + salaire;
        }
        return somme;
    }

    public static void DisplayNbSalarie(){
        System.out.println("Le nombre de salarié actuel est de " + nbSalarie);
    }

}
