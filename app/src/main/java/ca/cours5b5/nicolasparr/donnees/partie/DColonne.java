package ca.cours5b5.nicolasparr.donnees.partie;


import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.global.GLog;

public class DColonne {

    private List<DCase> cases = new ArrayList<>();

    public List<DCase> getCases() {
        GLog.appel(this);

        return cases;
    }

    public void setCases(List<DCase> cases) {
        GLog.appel(this);

        this.cases = cases;
    }

    public void ajouterJeton(ECouleur couleur) {
        GLog.appel(this);

        DCase _case = new DCase();

        _case.setCouleur(couleur);

        cases.add(_case);
    }
}
