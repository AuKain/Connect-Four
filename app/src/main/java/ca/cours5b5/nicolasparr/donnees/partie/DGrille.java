package ca.cours5b5.nicolasparr.donnees.partie;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.global.GLog;

public class DGrille extends Donnees {

    List<DColonne> colonnes;

    public DGrille (int nbColonnes, int nbCases) {
        GLog.appel(this);
        colonnes = new ArrayList<>();

        for (int i = 0; i < nbColonnes; i++) {
            colonnes.add(new DColonne(nbCases));
        }
    }

    public List<DColonne> getGrille () {
        GLog.valeurs(this.colonnes);
        return this.colonnes;
    }
}
