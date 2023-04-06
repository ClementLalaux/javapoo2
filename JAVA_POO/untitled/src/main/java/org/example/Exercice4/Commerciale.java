package org.example.Exercice4;

public class Commerciale extends Salarie{

    private float chiffreAffaire;
    private float commision;

    public Commerciale(int matricule, String categorie, String service, String nom, float salaire, float chiffreAffaire, float commision) {
        super(matricule, categorie, service, nom, salaire);
        this.chiffreAffaire = chiffreAffaire;
        this.commision = commision;
    }

    public float getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(float chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public float getCommision() {
        return commision;
    }

    public void setCommision(float commision) {
        this.commision = commision;
    }

    @Override
    public void AfficherSalaire() {
        System.out.println("Le salaire est de " + (salaire + (chiffreAffaire*commision/100)));
    }
}
