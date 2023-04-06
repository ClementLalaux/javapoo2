package org.example.Exercice6;

public class House {

    public int surface;
    public Door door;

    public House(int surface, Door door) {
        this.surface = surface;
        this.door = door;
    }

    public void display(){
        System.out.println("Je suis une maison ma surface est de " + surface + " m²");
    }

    public Door getDoor() {
        return door;
    }


}
