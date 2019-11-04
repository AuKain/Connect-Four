package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
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
        grille.creerGrille(donnees.getTailleGrille().getHauteur(), donnees.getTailleGrille().getLargeur());
    }

    @Override
    public void installerCapteurs(final MPartie modele) {
        for (int i = 0; i < grille.getGrille().size(); i++) {

            final int finalI = i;
            grille.getGrille().get(i).getEntete().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modele.jouerColonne(finalI);
                }
            });
        }
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
    }
}
