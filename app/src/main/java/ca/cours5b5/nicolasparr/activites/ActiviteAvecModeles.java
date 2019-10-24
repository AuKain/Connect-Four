package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;

public abstract class ActiviteAvecModeles<D extends Donnees, M extends Modele, P extends PageAvecModeles> extends Activite {

    private D donnees;
    private P page;
    private M modele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);

        super.onCreate(savedInstanceState);
        initialiserDonneesPageModele();
    }

    private void initialiserDonneesPageModele() {
        GLog.appel(this);

        initialiserPageModele(this.donnees = recupererDonnees());
    }

    private void initialiserPageModele(D donnees) {
        GLog.appel(this);

        (this.page = findViewById(getIdPage())).creerAffichage(donnees);
        this.modele = creerModele(donnees, this.page);
    }

    private D recupererDonnees() {
        GLog.appel(this);

        return EntrepotDeDonnees.obtenirDonnees(getClassDonnees());
    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract M creerModele(D donnees, P page);
}
