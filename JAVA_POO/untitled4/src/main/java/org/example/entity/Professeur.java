package org.example.entity;

import javax.persistence.*;

@Entity
public class Professeur extends Personne{

    private String matiere;

    public Professeur() {
        super();
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return super.toString() + "Professeur{" +
                "matiere='" + matiere + '\'' +
                '}';
    }
}
