package ca.cours5b5.nicolasparr.modeles;

import java.util.List;

import ca.cours5b5.nicolasparr.donnees.partie.DCase;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.vues.pages.PPartie;

public abstract class MPartie extends Modele<DPartie, PPartie> {

    public MPartie(DPartie donnees, PPartie page) {
        super(donnees, page);
    }

    //TODO Ajouter des méthodes publiques que la page va appeler pour mettre à jour les données

    public void jouerColonne(int noColonne) {

        List<DCase> colonnes = donnees.getGrille().getGrille().get(noColonne).getColonne();

        for (int i = colonnes.size() - 1; i >= 0; i--) {
            if (colonnes.get(i).getCouleur() == null) {
                colonnes.get(i).setCouleur(donnees.getCouleur());
                donnees.prochaineCouleur();
                break;
            }
            if (i == 0) {
                break;
            }
        }
        page.rafraichirAffichage(donnees);
    }
}
