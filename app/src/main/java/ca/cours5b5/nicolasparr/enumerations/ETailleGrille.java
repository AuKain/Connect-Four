package ca.cours5b5.nicolasparr.enumerations;


import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;

public enum ETailleGrille {

    PETITE,
    MOYENNE,
    GRANDE;

    public int getHauteur() {
        GLog.appel(this);

        switch (this) {
            case PETITE:

                return GConstantes.HAUTEUR_PETITE_GRILLE;

            case MOYENNE:

                return GConstantes.HAUTEUR_MOYENNE_GRILLE;

            case GRANDE:

                return GConstantes.HAUTEUR_GRANDE_GRILLE;
        }

        throw new RuntimeException("Taille inconnue: " + this.name());

    }

    public int getLargeur() {
        GLog.appel(this);

        switch (this) {
            case PETITE:

                return GConstantes.LARGEUR_PETITE_GRILLE;

            case MOYENNE:

                return GConstantes.LARGEUR_MOYENNE_GRILLE;

            case GRANDE:

                return GConstantes.LARGEUR_GRANDE_GRILLE;
        }

        throw new RuntimeException("Taille inconnue: " + this.name());

    }






}
