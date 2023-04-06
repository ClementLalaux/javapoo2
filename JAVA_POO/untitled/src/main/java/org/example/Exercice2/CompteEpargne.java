package org.example.Exercice2;

public class CompteEpargne extends Compte{
    float interet;
    public CompteEpargne(int code, float solde,float interet) {
        super(code, solde);
        this.interet = interet;
    }

    public void calculInterets(){
        solde = solde + ((this.solde *this.interet)/100);
    }
}
