package ca.cours5b5.nicolasparr.modeles;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;


public abstract class Modele <D extends Donnees, P extends PageAvecModeles> {

    protected D donnees;
    protected P page;

    public Modele(D donnees, P page){
        GLog.appel(this);

        this.donnees = donnees;
        this.page = page;

        initialiserCommandes();
    }

    protected void notifierModificationLocale() {
        GLog.appel(this);

        this.donnees.notifierModificationLocale();

        EntrepotDeDonnees.sauvegarderDonneesSurServeur(donnees);
    }

    public void detruire() {
        GLog.appel(this);

        this.page.detruireAffichage();
    }

    protected abstract void initialiserCommandes();
}
