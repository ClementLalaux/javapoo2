package org.example.Exercice2;

public class Compte {

    static int nbCompte = 0;

    int code;
    float solde;

    public Compte(int code, float solde) {
        this.code = ++nbCompte;
        this.solde = solde;
    }

    public void versement(float vers){
        solde = solde+vers;
    }

    public void retrait(float ret){
        if(solde>=ret){
            solde = this.solde-ret;
        }
    }

}
