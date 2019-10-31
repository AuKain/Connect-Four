package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Random;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartie;
import ca.cours5b5.nicolasparr.vues.controles.VGrille;

public class PPartieLocale extends PPartie {

    TextView joueur1, joueur2;
    VGrille grille;

    public PPartieLocale(Context context) {
        super(context);
    }

    public PPartieLocale(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PPartieLocale(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        GLog.appel(this);
    }

    @Override
    public void creerAffichage(DPartie donnees) {
        //TODO
    }

    @Override
    public void installerCapteurs(MPartie modele) {
        //TODO
    }

    @Override
    public void rafraichirAffichage(DPartie donnees) {
        //TODO
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        joueur1 = this.findViewById(R.id.textJoueurA);
        joueur2 = this.findViewById(R.id.textJoueurB);
        grille = this.findViewById(R.id.grille);
        grille.creerGrille(new Random().nextInt(4) + 3, new Random().nextInt(4) + 3);
    }
}
