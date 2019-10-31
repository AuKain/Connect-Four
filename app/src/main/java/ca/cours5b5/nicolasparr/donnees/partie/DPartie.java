package ca.cours5b5.nicolasparr.donnees.partie;

import android.graphics.Color;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;

public abstract class DPartie extends Donnees {

    private ETailleGrille tailleGrille;
    private DGrille grille;
    private Color prochaineCouleur;

    public ETailleGrille getTailleGrille() {
        return tailleGrille;
    }

    public DGrille getGrille() {
        return grille;
    }

    public Color getProchaineCouleur() {
        return prochaineCouleur;
    }
}
