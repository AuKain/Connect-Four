package ca.cours5b5.nicolasparr.donnees.partie;

import android.graphics.Color;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;

public abstract class DPartie extends Donnees {

    private ETailleGrille tailleGrille;
    private DGrille grille;
    private ECouleur prochaineCouleur;


    public ETailleGrille getTailleGrille() {
        return tailleGrille;
    }

    public void setTailleGrille(ETailleGrille tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    public DGrille getGrille() {
        return grille;
    }

    public void setGrille(DGrille grille) {
        this.grille = grille;
    }

    public ECouleur getProchaineCouleur() {
        return prochaineCouleur;
    }

    public void setProchaineCouleur(ECouleur prochaineCouleur) {
        this.prochaineCouleur = prochaineCouleur;
    }
}
