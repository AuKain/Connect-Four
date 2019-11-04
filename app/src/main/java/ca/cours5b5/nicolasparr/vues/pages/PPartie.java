package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DCase;
import ca.cours5b5.nicolasparr.donnees.partie.DColonne;
import ca.cours5b5.nicolasparr.donnees.partie.DGrille;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
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
        List<DColonne> grille = donnees.getGrille().getGrille();

        for (int i = 0; i < grille.size(); i++) {
            for (int j = 1; j < grille.get(i).getColonne().size(); j++) {
                DCase leCase = grille.get(i).getColonne().get(j);
                if (leCase.getCouleur() != null) {
                    this.grille.getGrille().get(i).getColonne().get(j).setBackgroundColor(getResources()
                            .getColor(((donnees.getCouleur() == ECouleur.ROUGE)? R.color.colorJoueurA : R.color.colorJoueurB)));
                }
            }
        }
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        joueur1 = this.findViewById(R.id.textJoueurA);
        joueur2 = this.findViewById(R.id.textJoueurB);
        grille = this.findViewById(R.id.grille);
    }
}
