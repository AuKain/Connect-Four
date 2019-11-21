package ca.cours5b5.nicolasparr.vues.controles;


import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.Random;

import ca.cours5b5.nicolasparr.donnees.partie.DColonne;
import ca.cours5b5.nicolasparr.donnees.partie.DGrille;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartie;


public class VGrille extends LinearLayout {

    VColonne[] colonnes;

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void creerGrille(int hauteur, int largeur) {
        GLog.appel(this);

        setOrientation(LinearLayout.HORIZONTAL);

        ajouterColonnes(hauteur, largeur);

    }

    private void ajouterColonnes(int hauteur, int largeur) {
        GLog.appel(this);

        colonnes = new VColonne[largeur];

        for (int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {

            VColonne vColonne = new VColonne(getContext(), hauteur, indiceColonne);

            LayoutParams layoutParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f);

            this.addView(vColonne, layoutParams);

            colonnes[indiceColonne] = vColonne;

        }
    }

    public void detruireGrille() {
        GLog.appel(this);

        this.removeAllViews();
        colonnes = null;

    }

    public void installerCapteurs(MPartie modele){
        GLog.appel(this);

        for(int i = 0; i < colonnes.length; i++){
            colonnes[i].installerCapteur(modele);
        }

    }

    public void afficher(DGrille dGrille) {
        GLog.appel(this);

        for(int i = 0; i < colonnes.length; i++){

            int cle = i;

            DColonne dColonne = dGrille.getColonnes().get(cle);

            colonnes[i].afficher(dColonne);

        }
    }
}

