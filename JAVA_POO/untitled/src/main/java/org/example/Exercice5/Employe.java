package org.example.Exercice5;

public class Employe {

    public String nom;
    public int age;
    public float salaire;

    float somme = 0;

    public Employe() {
    }

    public Employe(String nom, int age, float salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }

    public void augmentation(float augment){
        salaire = salaire + augment;
    }

    public float calculSalaire(int mois){
        for (int i = 0; i < mois; i++) {
           somme += salaire;
        }
        return  somme;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", salaire=" + salaire +
                '}';
    }
}
