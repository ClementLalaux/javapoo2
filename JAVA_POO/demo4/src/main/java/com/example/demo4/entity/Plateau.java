package com.example.demo4.entity;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private List<Case> cases;
    public Case uneCase;

    public List<Case> remplirLaGrille(){
        int x = 1;
        int y = 1;
        cases = new ArrayList<>();

        while (y<=10){
            while(x<=10){
                uneCase = new Case(x,y,false);
                addCases(uneCase);
                x++;
            }
            y++;
            x = 0;
        }
        return cases;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public void addCases(Case aCase){
        getCases().add(aCase);
    }
}
