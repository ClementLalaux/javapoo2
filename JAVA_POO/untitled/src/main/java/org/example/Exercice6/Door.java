package org.example.Exercice6;

public class Door {

    public String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void Display(){
        System.out.println("Je suis une porte est ma couleur est " + getColor());
    }
}
