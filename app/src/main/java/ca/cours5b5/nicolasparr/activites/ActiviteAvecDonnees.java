package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecDonnees;

public abstract class ActiviteAvecDonnees<D extends Donnees, P extends PageAvecDonnees> extends Activite {

    private D donnees;
    private P page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        GLog.appel(this);
        super.onCreate(savedInstanceState);

        initialiserDonneesPage();
    }

    private void initialiserDonneesPage() {

        GLog.appel(this);
        initialiserPage(this.donnees = creerDonnees());
    }

    private void initialiserPage(D donnees) {

        GLog.appel(this);
        (this.page = recupererPage()).creerAffichage(donnees);
    }

    private P recupererPage() {

        GLog.appel(this);
        return findViewById(getIdPage());
    }

    @Override
    protected void onResume() {

        super.onResume();
        GLog.appel(this);
        this.page.rafraichirAffichage(this.donnees);
    }

    protected abstract int getIdPage();

    protected abstract D creerDonnees();
}
