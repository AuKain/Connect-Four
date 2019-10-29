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
        initialiserDonneesPageModele(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EntrepotDeDonnees.sauvegarderDonnees(donnees, outState);
    }

    private void initialiserDonneesPageModele(Bundle etat) {
        GLog.appel(this);

        initialiserPageModele(this.donnees = recupererDonnees(etat));
    }

    private void initialiserPageModele(D donnees) {
        GLog.appel(this);

        (this.page = findViewById(getIdPage())).creerAffichage(donnees);
        this.modele = creerModele(donnees, this.page);
    }

    private D recupererDonnees(Bundle etat) {
        GLog.appel(this);

        return EntrepotDeDonnees.obtenirDonnees(getClassDonnees(), etat);
    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract M creerModele(D donnees, P page);
}
