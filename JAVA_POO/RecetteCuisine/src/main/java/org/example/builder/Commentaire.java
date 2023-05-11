package org.example.builder;

public class Commentaire {

    private int id;
    private String pseudo;
    private String texte;
    private int recetteId;

    public Commentaire(Builder builder){
        this.id = builder.id;
        this.pseudo = builder.pseudo;
        this.texte = builder.texte;
        this.recetteId = builder.recetteId;
    }

    public static class Builder {
        private int id;
        private String pseudo;
        private String texte;
        private int recetteId;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder pseudo(String pseudo){
            this.pseudo = pseudo;
            return this;
        }

        public Builder texte(String texte){
            this.texte = texte;
            return this;
        }

        public Builder recetteId(int recetteId){
            this.recetteId = recetteId;
            return this;
        }

        public Commentaire build(){
            return new Commentaire(this);
        }
    }
}
