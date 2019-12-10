package ca.cours5b5.nicolasparr.commandes;

import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PageAvecModeles;

public class CMessagePuisCommande extends Commande {

    /*
     * Attribut privé statique pour stoquer
     * le bon contexte pour la commande, p.ex:
     * activité, modèle ou page
     */
    private static PageAvecModeles page;

    public static void initialiser(PageAvecModeles page) {

        CMessagePuisCommande.page = page;
    }

    private int message;
    private Commande commande;

    public CMessagePuisCommande(int message, Commande commande) {
        GLog.appel(this);

        this.message = message;
        this.commande = commande;
    }

    @Override
    public void executer() {
        GLog.appel(this);

        page.afficherMessagePuisExecuterCommande(message, commande);
    }
}
