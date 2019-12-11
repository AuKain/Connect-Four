package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;

public class DParametres extends Donnees<DParametres> {


    private ETailleGrille tailleGrille = GConstantes.TAILLE_GRILLE_PAR_DEFAUT;
    private boolean siContinuerPartiePrecedente = GConstantes.SI_CONTINUER_PARTIE_PAR_DEFAUT;


    public ETailleGrille getTailleGrille() {
        GLog.appel(this);

        return tailleGrille;
    }

    public void setTailleGrille(ETailleGrille tailleGrille) {
        GLog.appel(this);

        this.tailleGrille = tailleGrille;
    }

    public boolean getContinuerPartiePrecedente() {
        GLog.appel(this);

        return siContinuerPartiePrecedente;
    }

    public void setContinuerPartiePrecedente(boolean siContinuerPartiePrecedente) {
        GLog.appel(this);
        this.siContinuerPartiePrecedente = siContinuerPartiePrecedente;
    }

    @Override
    public void copierDonnees(DParametres dParametres) {
        /*
         * TODO Appeler super.copierDonnees
         *  .
         *  Copier les données
         *
         */
    }
}
