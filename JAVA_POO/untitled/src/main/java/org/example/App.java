package org.example;

import org.example.Book.*;
import org.example.Collections.CercleDemo;
import org.example.Collections.ListDemo;
import org.example.Enum.EnumUn;
import org.example.Exercice1.Chaises;
import org.example.Exercice3.Student;
import org.example.Exercice3.Teacher;
import org.example.Exercice6.Door;
import org.example.Exercice6.House;
import org.example.Exercice6.Person;
import org.example.Recursive.factoriel;
import org.example.Recursive.factorielDeux;
import org.example.Recursive.multiplie;
import org.example.Stream.Trader;
import org.example.Stream.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */


public class App
{
    public static void main( String[] args )
    {
        /*Auteur auteur1 = new Auteur("Jon", "Johnson");
        Editeur editeur1 = new Editeur("Publisher_1");

        Book[] livres = new Book[] {
                new Book( "Book_1", new Auteur[] { auteur1 }, editeur1, 1990, 231, 24.99, CoverType.Broché),
                new Book( "Book_2", new Auteur[] { auteur1 , new Auteur("William", "Wilson") }, new Editeur( "Publisher_2 "), 2000, 120, 14.99, CoverType.Broché),
                new Book( "Book_4",new Auteur[]{new Auteur( "Walter", "Peterson") }, new Editeur( "Publisher_1"), 1997, 350, 34.99, CoverType.Relié),
                new Book("Book_4", new Auteur[] { new Auteur( "Craig", "Gregory") }, new Editeur( "Publisher_3"), 1992, 185, 19.99, CoverType.Broché) };

        BookService bookService = new BookService();

        for (Book book : bookService.filterBooksByAuthor(auteur1,livres)) {
            System.out.println(book.getName());
        }

        for (Book book : bookService.filterBooksByPublisher(editeur1,livres)) {
            System.out.println(book.getName());
        }

        for (Book book : bookService.filterBooksByYears(1993,livres)) {
            System.out.println(book.getName());
        }*/

        //ListDemo.main();

        //CercleDemo.main();

        Trader abdallah = new Trader("Abdallah","Cambridge");
        Trader audrey = new Trader("Audrey","Milan");
        Trader corentin = new Trader("Corentin","Cambridge");
        Trader tristan = new Trader("Tristan","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(abdallah,2011,500),
                new Transaction(abdallah,2012,300),
                new Transaction(corentin,2012,710),
                new Transaction(corentin,2012,700),
                new Transaction(audrey,2012,1000),
                new Transaction(audrey,2011,400),
                new Transaction(tristan,2012,950),
                new Transaction(tristan,2022,900)
        );

        transactions.stream().filter(t -> t.getYear() == 2011).sorted(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getValue()-o2.getValue();
            }
        }).forEach(System.out::println);

        List<String> villes = new ArrayList<>();

        villes = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());

        transactions.stream().map(transaction -> transaction.getTrader()
                .getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println(villes.stream().anyMatch(v-> v == "Milan"));

        System.out.println(transactions.stream().map(e->e.getValue()).max(Integer::compare).get());

        System.out.println("------------------------");

        List<Trader> traderCambridge = new ArrayList<>();

        traderCambridge = transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(v->v.getTrader()).sorted(new Comparator<Trader>() {
                    @Override
                    public int compare(Trader o1, Trader o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }).distinct().collect(Collectors.toList());

        System.out.println(traderCambridge);

        List<Integer> listTransactionCambrige = new ArrayList<>();

        listTransactionCambrige = transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(v-> v.getValue()).collect(Collectors.toList());

        System.out.println(transactions.stream().map(transaction -> transaction.getValue()).min(Integer::compare));

    }
}
