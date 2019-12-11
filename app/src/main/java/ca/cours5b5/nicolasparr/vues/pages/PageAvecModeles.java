package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.snackbar.Snackbar;

import ca.cours5b5.nicolasparr.commandes.Commande;
import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;

public abstract class PageAvecModeles<D extends Donnees, M extends Modele> extends Page {

    public PageAvecModeles(Context context) {
        super(context);
    }

    public PageAvecModeles(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PageAvecModeles(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void afficherMessagePuisExecuterCommande(int message, final Commande commande) {
        GLog.appel(this);

        Snackbar fenetreMessage = Snackbar.make(this, getResources().getString(message), Snackbar.LENGTH_SHORT);
        fenetreMessage.addCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed (Snackbar snackbar, int event) {
                commande.executer();
            }
        });

        fenetreMessage.show();
    }

    public abstract void detruireAffichage();

    public abstract void creerAffichage(D donnees);

    public abstract void rafraichirAffichage(D donnees);

    public abstract void creerCommandes();

    public abstract void installerCapteurs();

    public abstract void rafraichirCommandes();
}
