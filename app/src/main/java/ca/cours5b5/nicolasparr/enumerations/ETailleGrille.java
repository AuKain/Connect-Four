package ca.cours5b5.nicolasparr.enumerations;

import android.widget.Switch;

public enum ETailleGrille {
    PETITE ("Petite"),
    MOYENNE ("Moyenne"),
    GRANDE ("Grande");

    private final String taille;

    ETailleGrille(String taille) {
        this.taille = taille;
    }

    public String getValue() {
        return this.taille;
    }
}