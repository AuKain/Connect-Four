package ca.cours5b5.nicolasparr.donnees.partie;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.donnees.Donnees;

public class DColonne extends Donnees {

    private List<DCase> cases;

    public DColonne (int nbCases) {
        cases = new ArrayList<>();

        for (int i = 0; i < nbCases; i++) {
            cases.add(new DCase());
        }
    }

    public DCase getCase (int noCase) {
        return this.cases.get(noCase);
    }

    public void setCase (DCase laCase) {
        this.cases.add(laCase);
    }

    public List<DCase> getColonne() {
        return cases;
    }

    public void setColonne(List<DCase> colonne) {
        this.cases = colonne;
    }
}
