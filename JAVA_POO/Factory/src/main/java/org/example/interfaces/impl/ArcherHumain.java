package org.example.interfaces.impl;


import org.example.interfaces.Archer;

public class ArcherHumain implements Archer {
    @Override
    public void tirer() {
        System.out.println("Un humain archer");
    }
}
