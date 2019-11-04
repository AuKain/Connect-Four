package ca.cours5b5.nicolasparr.donnees.partie;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.donnees.Donnees;

public class DGrille extends Donnees { //TODO

    List<DColonne> colonnes;

    public DGrille (int nbColonnes, int nbCases) {
        colonnes = new ArrayList<>();

        for (int i = 0; i < nbColonnes; i++) {
            colonnes.add(new DColonne(nbCases));
        }
    }

    public DColonne getColonne (int noColonne) {
        return this.colonnes.get(noColonne);
    }

    public List<DColonne> getGrille () {
        return this.colonnes;
    }

    public void setColonne (DColonne colonne) {
        this.colonnes.add(colonne);
    }
}
