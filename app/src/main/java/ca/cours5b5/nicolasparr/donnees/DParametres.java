package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.global.GConstantes;

public class DParametres extends Donnees {

    private String tailleGrille = GConstantes.tailleDefaut;
    private boolean continuerPartiePrec = GConstantes.continuerPartiePrec;

    DParametres() { }

    DParametres(String tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    DParametres(boolean continuerPartiePrec) {
        this.continuerPartiePrec = continuerPartiePrec;
    }

    DParametres(String tailleGrille, boolean continuerPartiePrec) {
        this.tailleGrille = tailleGrille;
        this.continuerPartiePrec = continuerPartiePrec;
    }

    public String getTailleGrille() {
        return tailleGrille;
    }

    public boolean isContinuerPartiePrec() {
        return continuerPartiePrec;
    }

    public void setTailleGrille(String tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    public void setContinuerPartiePrec(boolean continuerPartiePrec) {
        this.continuerPartiePrec = continuerPartiePrec;
    }
}
