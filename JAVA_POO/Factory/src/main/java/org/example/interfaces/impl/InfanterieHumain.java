package org.example.interfaces.impl;

import org.example.interfaces.Infanterie;

public class InfanterieHumain implements Infanterie {
    @Override
    public void combattre() {
        System.out.println("Infanterie humain");
    }
}
