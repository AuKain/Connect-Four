package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecDonnees;

public abstract class ActiviteAvecDonnees<D extends Donnees, P extends PageAvecDonnees> extends Activite {

    private D donnees;
    private P page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initialiserDonneesPage();

        //donnees = creerDonnees();
        //page = recupererPage();
    }

    private void initialiserDonneesPage() {

        initialiserPage(this.donnees = creerDonnees());
    }

    private void initialiserPage(D donnees) {

        recupererPage().creerAffichage(donnees);
    }

    private P recupererPage() {

        return findViewById(getIdPage());
    }

    @Override
    protected void onResume() {

        super.onResume();
        this.page.rafraichirAffichage(this.donnees);
    }

    protected abstract int getIdPage();

    protected abstract D creerDonnees();
}
