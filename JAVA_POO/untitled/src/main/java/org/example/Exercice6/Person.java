package org.example.Exercice6;

public class Person {

    public String nom;
    public House house;

    public Person(String nom, House house) {
        this.nom = nom;
        this.house = house;
    }

    public void display(){
        System.out.println("je m'appelle " + nom + " ; ");
        house.display();
        house.door.Display();
    }
}
