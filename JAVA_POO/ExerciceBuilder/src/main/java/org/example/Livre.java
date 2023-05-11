package org.example;


public class Livre {
    private String titre;
    private String auteur;
    private int nbPages;
    private int anneePublication;
    private String genre;
    private String isbn;

    public Livre(Builder builder){
        titre = builder.titre;
        auteur = builder.auteur;
        nbPages = builder.nbPages;
        anneePublication = builder.anneePublication;
        genre = builder.genre;
        isbn = builder.isbn;
    }

    public static class Builder {
        private String titre;
        private String auteur;
        private int nbPages;
        private int anneePublication;
        private String genre;
        private String isbn;

        public Builder titre(String titre) {
            this.titre = titre;
            return this;
        }
        public Builder auteur(String auteur) {
            this.auteur = auteur;
            return this;
        }
        public Builder nbPages(int nbPages) {
            this.nbPages = nbPages;
            return this;
        }
        public Builder anneePublication(int anneePublication) {
            this.anneePublication = anneePublication;
            return this;
        }
        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }
        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Livre build(){
            return new Livre(this);
        }
    }
}
