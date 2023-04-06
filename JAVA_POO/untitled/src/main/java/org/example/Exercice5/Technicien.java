package org.example.Exercice5;

public class Technicien extends Employe{

    public int grade;

    public Technicien(String nom, int age, float salaire, int grade) {
        super(nom, age, salaire);
        this.grade = grade;
    }

    public int prime(){
        if(grade == 1){
            return 100;
        } else if (grade == 2) {
            return  200;
        } else if (grade == 3) {
            return 300;
        } else {
            return -1;
        }
    }

    @Override
    public float calculSalaire(int mois) {
        for (int i = 0; i < mois; i++) {
            if(prime()==-1){
                somme += salaire;
            }
            else {
                somme = somme + (salaire+prime());
            }
        }
        return  somme;
    }

}
