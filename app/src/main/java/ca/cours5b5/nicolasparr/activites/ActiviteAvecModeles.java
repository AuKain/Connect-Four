package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import java.io.File;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;

public abstract class ActiviteAvecModeles<D extends Donnees, M extends Modele, P extends PageAvecModeles>

        extends Activite {

    private D donnees;
    private P page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);

        super.onCreate(savedInstanceState);

        initialiserDonneesPageModele(savedInstanceState);

    }

    private void initialiserDonneesPageModele(Bundle etat){
        GLog.appel(this);

        donnees = recupererDonnees(etat);

        initialiserPageModele(donnees);

    }

    private void initialiserPageModele(D donnees){
        GLog.appel(this);

        initialiserPage(donnees);

        initialiserModele(donnees, page);

    }

    private void initialiserPage(D donnees) {
        GLog.appel(this);

        page = recupererPage();
        page.creerAffichage(donnees);
    }

    private void initialiserModele(D donnees, P page){
        GLog.appel(this);

        creerModele(donnees, page);
    }



    private P recupererPage() {
        GLog.appel(this);

        int idPage = getIdPage();

        return findViewById(idPage);
    }

    protected D recupererDonnees(Bundle etat) {
        GLog.appel(this);

        Class<D> classeDonnees = getClassDonnees();

        File repertoireDonnees = repertoireDonnees();

        return EntrepotDeDonnees.obtenirDonnees(classeDonnees, etat, repertoireDonnees);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        GLog.appel(this);

        super.onSaveInstanceState(outState);

        EntrepotDeDonnees.sauvegarderDansEtat(donnees, outState);

    }

    @Override
    protected void onPause() {
        GLog.appel(this);
        super.onPause();

        File repertoireDonnees = repertoireDonnees();

        EntrepotDeDonnees.sauvegarderSurDisque(donnees, repertoireDonnees);

    }


    protected void onResume() {
        GLog.appel(this);

        super.onResume();

        page.rafraichirAffichage(donnees);

    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract void creerModele(D donnees, P page);
}
