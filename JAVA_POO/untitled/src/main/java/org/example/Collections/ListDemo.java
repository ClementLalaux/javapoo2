package org.example.Collections;

import org.example.Collections.entity.RandomPerson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDemo {


    public static List<RandomPerson> listeDemo = new ArrayList<>();


    public static void main(){
        List<String> liste = new ArrayList<>();
        ArrayList<Integer> listeNombres = new ArrayList<Integer>();


        listeNombres.add(7);
        listeNombres.add(-2);
        listeNombres.add(4);

            // Méthodes pour trié du plus petit au plus grand
        //Collections.sort(listeNombres);
        //listeNombres.sort(Comparator.naturalOrder());
        //List<Integer> sortedList = listeNombres.stream().sorted().collect(Collectors.toList());


            // Méthodes pour trié du plus grand au plus petit
        //listeNombres.sort(Comparator.reverseOrder());

        //Collections.sort(listeNombres);
        //Collections.reverse(listeNombres);



        //System.out.println(sortedList);
        System.out.println(listeNombres);

        /*for (Integer i : listeNombres) {
            if(i%2==0){
                System.out.println(i);
            }
        }*/

        /*for (Integer i : listeNombres) {
            if(i%2!=1){
                System.out.println(i);
            }
        }*/

        /*for (int i = 0; i < listeNombres.size(); i++) {
            if(listeNombres.get(i) < 0){
                listeNombres.set(i,0);
            }
        }*/

        for (Integer i: listeNombres) {
            if(i<0){
                listeNombres.set(listeNombres.indexOf(i),0);
            }
        }

        System.out.println(listeNombres);

    }

}
