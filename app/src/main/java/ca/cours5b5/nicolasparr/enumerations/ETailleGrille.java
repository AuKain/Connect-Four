package ca.cours5b5.nicolasparr.enumerations;

import ca.cours5b5.nicolasparr.global.GLog;

public enum ETailleGrille {
    PETITE,
    MOYENNE,
    GRANDE;

    public int getHauteur() {
        GLog.appel(this);
        switch (this) {
            case PETITE:
                return 4;
            case MOYENNE:
                return 6;
            case GRANDE:
                return 7;
            default:
                throw new RuntimeException("If you reach this.......... welp I fucked up...");
        }
    }

    public int getLargeur() {
        GLog.appel(this);
        switch (this) {
            case PETITE:
                return 5;
            case MOYENNE:
                return 7;
            case GRANDE:
                return 10;
            default:
                throw new RuntimeException("If you reach this.......... welp I fucked up...");
        }
    }
}
