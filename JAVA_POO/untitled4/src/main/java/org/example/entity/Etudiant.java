package org.example.entity;

import javax.persistence.Entity;

@Entity
public class Etudiant extends Personne{

    private String classe;

    public Etudiant() {
        super();
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return super.toString() + "Etudiant{" +
                "classe='" + classe + '\'' +
                '}';
    }
}

