package org.example.interfaces;

import org.example.interfaces.impl.ArcherOrc;
import org.example.interfaces.impl.CavalierOrc;
import org.example.interfaces.impl.InfanterieOrc;

public class OrcFactory extends FactionFactory{
    @Override
    public Cavalier creerCavalier() {
        return new CavalierOrc();
    }

    @Override
    public Archer creerArcher() {
        return new ArcherOrc();
    }

    @Override
    public Infanterie creerInfanterie() {
        return new InfanterieOrc();
    }
}
