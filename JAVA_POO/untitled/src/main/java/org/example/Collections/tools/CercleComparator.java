package org.example.Collections.tools;

import org.example.Collections.Cercle;
import org.example.Collections.Order;

import java.util.Comparator;

public class CercleComparator implements Comparator<Cercle> {
    Order order;

    @Override
    public int compare(Cercle o1, Cercle o2) {
        switch (order){
            case X :
                return o1.getX().compareTo(o2.getX());
            case Y:
                return o1.getY().compareTo(o2.getY());
            case RAYON:
                return o1.getRayon().compareTo(o2.getRayon());
            default:
                return o1.getX().compareTo(o2.getX());
        }
    }

    public  void setOrder(Order order){this.order = order;}
}
