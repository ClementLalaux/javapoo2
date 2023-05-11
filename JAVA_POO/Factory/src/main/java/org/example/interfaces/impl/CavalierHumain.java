package org.example.interfaces.impl;

import org.example.interfaces.Cavalier;

public class CavalierHumain implements Cavalier {
    @Override
    public void charger() {
        System.out.println("Cavalier humain");
    }
}
