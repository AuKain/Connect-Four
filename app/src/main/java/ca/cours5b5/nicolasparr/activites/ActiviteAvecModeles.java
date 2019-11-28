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

    private P recupererPage() {
        GLog.appel(this);

        int idPage = getIdPage();

        return findViewById(idPage);
    }

    private void creerAffichage() {
        //TODO Appeler la page pour créer l'affichage
    }

    private void initialiserPage(D donnees) {
        GLog.appel(this);

        page = recupererPage();
        page.creerAffichage(donnees);
    }

    private void rafraichirAffichage() {
        //TODO Appeler la page pour créer l'affichage
    }

    private void initialiserPage() {
        //TODO Créer affichage
        // Rafraîchir affichage
    }

    private void memoriserDonneesPuisInitialiserModelePage(D donneesObtenues) {
        //TODO Stoquer les données dans l'attribut
        // Initialiser la page
        // Créer le modèle (et le stoquer)
    }

    private void obtenirDonneesPuisInitialiserModelePage() {
        //TODO Obtenir les données, puis initialiser
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO Sauvegarder les données sur le serveur
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Récupérer la page et mémoriser dans l'attribut page
        // .
        // obtenir données et initialiser
    }

    protected abstract int getIdPage();

    protected abstract Class<D> getClassDonnees();

    protected abstract void creerModele(D donnees, P page);
}
