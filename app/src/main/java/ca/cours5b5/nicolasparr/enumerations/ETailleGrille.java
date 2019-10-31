package ca.cours5b5.nicolasparr.enumerations;

public enum ETailleGrille {
    PETITE,
    MOYENNE,
    GRANDE;

    public int getHauteur() {
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
