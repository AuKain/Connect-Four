package ca.cours5b5.nicolasparr.commandes;

import ca.cours5b5.nicolasparr.activites.Activite;
import ca.cours5b5.nicolasparr.global.GLog;

public class CQuitterActivite extends Commande {

    /*
     * Attribut privé statique pour stoquer
     * le bon contexte pour la commande, p.ex:
     * activité, modèle ou page
     */
    private static Activite activite;

    public static void initialiser(Activite activite) {
        // stoquer le contexte
        CQuitterActivite.activite = activite;
    }

    public CQuitterActivite() {
        GLog.appel(this);

    }

    @Override
    public void executer() {
        GLog.appel(this);

        activite.quitterActivite();
    }
}
