package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import java.io.File;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.donnees.RetourDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;

public abstract class ActiviteAvecModeles<D extends Donnees, M extends Modele, P extends PageAvecModeles>

        extends Activite {

    private D donnees;
    private P page;
    private M modele;

    private P recupererPage() {
        GLog.appel(this);

        int idPage = getIdPage();

        return findViewById(idPage);
    }

    private void creerAffichage() {
        GLog.appel(this);

        this.page.creerAffichage(this.donnees);

        this.page.creerCommandes();

        this.page.installerCapteurs();
    }

    private void rafraichirAffichage() {
        GLog.appel(this);

        this.page.rafraichirAffichage(this.donnees);
        this.page.rafraichirCommandes();
    }

    private void initialiserPage() {
        GLog.appel(this);

        creerAffichage();
        rafraichirAffichage();
    }

    private void memoriserDonneesPuisInitialiserModelePage(D donneesObtenues) {
        GLog.appel(this);

        this.donnees = donneesObtenues;

        this.modele = creerModele(this.donnees, this.page);

        initialiserPage();
    }

    private void obtenirDonneesPuisInitialiserModelePage() {
        EntrepotDeDonnees.obtenirDonnees(getClassDonnees(), new RetourDonnees<D>() {
            @Override
            public void recevoirDonnees(D donnees) {
                memoriserDonneesPuisInitialiserModelePage(donnees);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        GLog.appel(this);

        EntrepotDeDonnees.sauvegarderDonneesSurServeur(this.donnees);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLog.appel(this);

        this.page = recupererPage();

        obtenirDonneesPuisInitialiserModelePage();
    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract M creerModele(D donnees, P page);
}
