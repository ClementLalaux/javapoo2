package org.example.interfaces.impl;

import org.example.interfaces.Infanterie;

public class InfanterieOrc implements Infanterie {
    @Override
    public void combattre() {
        System.out.println("Infanterie orc");
    }
}
