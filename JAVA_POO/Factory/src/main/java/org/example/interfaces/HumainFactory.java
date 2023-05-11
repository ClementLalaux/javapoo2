package org.example.interfaces;

import org.example.interfaces.impl.ArcherHumain;
import org.example.interfaces.impl.CavalierHumain;
import org.example.interfaces.impl.InfanterieHumain;

public class HumainFactory extends FactionFactory{
    @Override
    public Cavalier creerCavalier() {
        return new CavalierHumain();
    }

    @Override
    public Archer creerArcher() {
        return  new ArcherHumain();
    }

    @Override
    public Infanterie creerInfanterie() {
        return new InfanterieHumain();
    }


}
