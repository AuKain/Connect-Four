package ca.cours5b5.nicolasparr.donnees.partie;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.global.GLog;

public class DColonne extends Donnees {

    private List<DCase> cases;

    public DColonne (int nbCases) {
        GLog.appel(this);
        cases = new ArrayList<>();

        for (int i = 0; i < nbCases; i++) {
            cases.add(new DCase());
        }
    }

    public List<DCase> getColonne() {
        GLog.valeurs(this.cases);
        return cases;
    }

    public void setColonne(List<DCase> colonne) {
        this.cases = colonne;
        GLog.valeurs(colonne);
    }
}
