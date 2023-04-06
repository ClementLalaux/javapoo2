package org.example.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    
    public List<Book> filterBooksByAuthor(Auteur author, Book[] books){
        List<Book> retour = new ArrayList<Book>();

        for (Book book: books) {
            for (int i = 0; i < book.getAuteurs().length; i++) {
                if (book.getAuteurs()[i] == author) {
                    retour.add(book);
                }
            }
        }
        return retour;
    }

    public List<Book> filterBooksByPublisher(Editeur editeur, Book[] books){
        List<Book> retourPublisher = new ArrayList<Book>();

        for (Book book: books) {
            if (book.getEditeur() == editeur) {
                retourPublisher.add(book);
            }
        }
        return retourPublisher;
    }

    public List<Book> filterBooksByYears(int years, Book[] books){
        List<Book> retourYears = new ArrayList<Book>();

        for (Book book: books) {
            if (book.getPublishingYears() >= years) {
                retourYears.add(book);
            }
        }
        return retourYears;
    }
    
}
