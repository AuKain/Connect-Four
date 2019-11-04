package ca.cours5b5.nicolasparr.donnees.partie;

import android.graphics.Color;
import android.os.Bundle;

import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;

public abstract class DPartie extends Donnees {

    private ETailleGrille tailleGrille;
    private DGrille grille;
    private ECouleur prochaineCouleur;

    public DPartie () {

        this.prochaineCouleur = ECouleur.ROUGE;
        this.tailleGrille = GConstantes.tailleDefaut;
        this.grille = new DGrille(this.tailleGrille.getLargeur(), this.tailleGrille.getHauteur());
    }

    public DPartie (ETailleGrille taille) {
        this.prochaineCouleur = ECouleur.ROUGE;
        this.tailleGrille = taille;
        this.grille = new DGrille(taille.getLargeur(), taille.getHauteur());
    }

    public ETailleGrille getTailleGrille() {
        return tailleGrille;
    }

    public DGrille getGrille() {
        return grille;
    }

    public ECouleur getCouleur() {
        return prochaineCouleur;
    }

    public void prochaineCouleur() {
        if (this.prochaineCouleur == ECouleur.ROUGE) {
            this.prochaineCouleur = ECouleur.BLEU;
        } else {
            this.prochaineCouleur = ECouleur.ROUGE;
        }
    }
}
