package ca.cours5b5.nicolasparr.modeles;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;


public abstract class Modele <D extends Donnees, P extends PageAvecModeles> {

    protected D donnees;
    protected P page;

    public Modele(D donnees, P page){
        this.donnees = donnees;
        this.page = page;

        page.installerCapteurs(this);
        initialiserCommandes();
    }

    protected abstract void initialiserCommandes();
}
