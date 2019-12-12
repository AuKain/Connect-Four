package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import java.io.File;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.donnees.Observateur;
import ca.cours5b5.nicolasparr.donnees.RetourDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;

public abstract class ActiviteAvecModeles<D extends Donnees, M extends Modele, P extends PageAvecModeles> extends Activite {

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
        GLog.appel(this);

        EntrepotDeDonnees.obtenirDonnees(getClassDonnees(), new RetourDonnees<D>() {
            @Override
            public void recevoirDonnees(D donnees) {
                memoriserDonneesPuisInitialiserModelePage(donnees);
            }
        });

    }

    private void detruireAncienModele() {
        GLog.appel(this);

        if (modele != null) {
            modele.detruire();
        }
    }

    private void memoriserDonneesPuisGererModelePage(D donneesRecues) {
        GLog.appel(this);

        detruireAncienModele();

        this.donnees = donneesRecues;

        this.modele = creerModele(donnees, page);

        initialiserPage();
    }

    private void reagirDonneesSurServeur(D donneesDuServeur) {
        GLog.appel(this);

        donnees.copierDonnees(donneesDuServeur);

        rafraichirAffichage();
    }

    protected void observerDonneesEtGererModelePage() {
        GLog.appel(this);

        EntrepotDeDonnees.observerDonnees(getClassDonnees(), new Observateur<D>() {
            @Override
            protected void nouveau(D donnees) {
                memoriserDonneesPuisGererModelePage(donnees);
            }

            @Override
            protected void donneesDuServeur(D donnees) {
                reagirDonneesSurServeur(donnees);
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

        observerDonneesEtGererModelePage();
    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract M creerModele(D donnees, P page);
}
