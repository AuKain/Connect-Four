package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartie;
import ca.cours5b5.nicolasparr.vues.controles.VGrille;

public abstract class PPartie extends PageAvecModeles<DPartie, MPartie> {

    TextView joueur1, joueur2;
    VGrille grille;

    public PPartie(Context context) {
        super(context);
    }

    public PPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        GLog.appel(this);
    }

    @Override
    public void creerAffichage(DPartie donnees) {
        switch (donnees.getTailleGrille()) {
            case PETITE:
                grille.creerGrille(ETailleGrille.PETITE.getHauteur(), ETailleGrille.PETITE.getLargeur());
                break;
            case MOYENNE:
                grille.creerGrille(ETailleGrille.MOYENNE.getHauteur(), ETailleGrille.MOYENNE.getLargeur());
                break;
            case GRANDE:
                grille.creerGrille(ETailleGrille.GRANDE.getHauteur(), ETailleGrille.GRANDE.getLargeur());
                break;
        }
    }

    @Override
    public void installerCapteurs(MPartie modele) {
        grille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });
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
