package ca.cours5b5.nicolasparr.modeles;

import ca.cours5b5.nicolasparr.commandes.CContinuerPartie;
import ca.cours5b5.nicolasparr.commandes.CTailleGrille;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PParametres;


public class MParametres extends Modele<DParametres, PParametres> {


    public MParametres(DParametres donnees, PParametres page) {
        super(donnees, page);
    }

    public void choisirTaille(ETailleGrille tailleGrille){
        GLog.appel(this);

        this.donnees.setTailleGrille(tailleGrille);

        this.page.rafraichirAffichage(this.donnees);
    }

    public void choisirSiContinuerPartie(boolean siContinuerPartie) {
        GLog.appel(this);

        this.donnees.setContinuerPartiePrecedente(siContinuerPartie);

        this.page.rafraichirAffichage(this.donnees);
    }

    @Override
    protected void initialiserCommandes() {
        GLog.appel(this);

        CContinuerPartie.initialiser(this);
        CTailleGrille.initialiser(this);
    }

    public ETailleGrille getTailleGrille() {
        GLog.appel(this);

        return this.donnees.getTailleGrille();
    }
}
