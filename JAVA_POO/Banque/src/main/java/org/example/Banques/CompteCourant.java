package org.example.Banques;

public class CompteCourant extends Compte{

    int decouvert;

    public CompteCourant(int code, float solde, int client_id, int decouvert) {
        super(code, solde, client_id);
        this.decouvert = decouvert;
    }

    @Override
    public void retrait(float ret) {
        if (solde >= ret + decouvert){
            solde = solde - ret;
        }
    }
}
