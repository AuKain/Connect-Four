package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;

public class DParametres extends Donnees {

    private ETailleGrille tailleGrille;
    private boolean continuerPartiePrec;

    public DParametres() {
        GLog.appel(this);
        this.tailleGrille = GConstantes.tailleDefaut;
        this.continuerPartiePrec = GConstantes.continuerPartiePrec;
    }

    public DParametres(ETailleGrille tailleGrille) {
        GLog.appel(this);
        this.tailleGrille = tailleGrille;
        this.continuerPartiePrec = GConstantes.continuerPartiePrec;
    }

    public DParametres(boolean continuerPartiePrec) {
        GLog.appel(this);
        this.continuerPartiePrec = continuerPartiePrec;
        this.tailleGrille = GConstantes.tailleDefaut;
    }

    public DParametres(ETailleGrille tailleGrille, boolean continuerPartiePrec) {
        GLog.appel(this);
        this.tailleGrille = tailleGrille;
        this.continuerPartiePrec = continuerPartiePrec;
    }

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
