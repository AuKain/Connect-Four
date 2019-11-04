package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;

public class DParametres extends Donnees {

    private ETailleGrille tailleGrille = GConstantes.tailleDefaut;
    private boolean continuerPartiePrec = GConstantes.continuerPartiePrec;

    public ETailleGrille getTailleGrille() {

        return tailleGrille;
    }

    public boolean isContinuerPartiePrec() {

        return continuerPartiePrec;
    }

    public void setTailleGrille(ETailleGrille tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    public void setContinuerPartiePrec(boolean continuerPartiePrec) {
        this.continuerPartiePrec = continuerPartiePrec;
    }
}
