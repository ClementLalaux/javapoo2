package org.example;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    public boolean TestTaille(){

        MyTest test = new MyTest("Mon Texte");
        if(test.nom.length()>2){
            return true;
        }
        return false;
    }

}
