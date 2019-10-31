package ca.cours5b5.nicolasparr.modeles;

import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.vues.pages.PPartie;

public abstract class MPartie extends Modele<DPartie, PPartie> {

    public MPartie(DPartie donnees, PPartie page) {
        super(donnees, page);
    }

    //TODO Ajouter des méthodes publiques que la page va appeler pour mettre à jour les données
}
