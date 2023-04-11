package org.example.Collections;


import org.example.Collections.tools.CercleComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CercleDemo {


    public static void main(){

        List<Cercle> listeCercle = new ArrayList<>();

        listeCercle.add(new Cercle(5,7,12.0));
        listeCercle.add(new Cercle(1,8,5.0));
        listeCercle.add(new Cercle(18,5,7.0));
        listeCercle.add(new Cercle(3,15,6.0));
        listeCercle.add(new Cercle(4,11,2.0));

        for (Cercle c: listeCercle
             ) {
            System.out.println("X : " + c.getX() + " , Y : " + c.getY() + " , Rayon : " + c.getRayon());
        }

        trieOrderCercle(Order.X,listeCercle);

        System.out.println(" -------- En fonction de X ---------- ");

        for (Cercle c: listeCercle
        ) {
            System.out.println("X : " + c.getX() + " , Y : " + c.getY() + " , Rayon : " + c.getRayon());
        }

        trieOrderCercle(Order.RAYON,listeCercle);

        System.out.println(" -------- En fonction du RAYON ---------- ");

        for (Cercle c: listeCercle
        ) {
            System.out.println("X : " + c.getX() + " , Y : " + c.getY() + " , Rayon : " + c.getRayon());
        }

    }

    public static void trieOrderCercle(Order order, List<Cercle> liste){
        CercleComparator cercleComparator = new CercleComparator();
        cercleComparator.setOrder(order);
        Collections.sort(liste, cercleComparator);
    }



}
