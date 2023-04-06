package org.example.Exercice2;

public class ComptePayant extends Compte{

    public ComptePayant(int code, float solde) {
        super(code, solde);
    }

    @Override
    public void versement(float vers) {
        solde = solde + vers - (vers*5/100);
    }

    @Override
    public void retrait(float ret) {
        if(solde >= ret + (ret*5/100)) {
            solde = solde - ret - (ret * 5 / 100);
        }
    }
}
