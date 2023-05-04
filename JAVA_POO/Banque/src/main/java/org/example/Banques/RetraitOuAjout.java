package org.example.Banques;

public enum RetraitOuAjout {
    RETRAIT,
    AJOUT;

    public static RetraitOuAjout fromInteger(int x) {
        switch(x) {
            case 0:
                return RETRAIT;
            case 1:
                return AJOUT;
        }
        return null;
    }

}
