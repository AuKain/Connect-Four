package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Random;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.commandes.CCoupIci;
import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartie;
import ca.cours5b5.nicolasparr.modeles.Modele;
import ca.cours5b5.nicolasparr.vues.controles.VColonne;
import ca.cours5b5.nicolasparr.vues.controles.VGrille;

public abstract class PPartie extends PageAvecModeles<DPartie, MPartie> {

    TextView texteNomJoueur01;
    TextView texteNomJoeuur02;

    VGrille grille;

    CCoupIci[] coupIcis;

    public PPartie(Context context) {
        super(context);
    }

    public PPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        GLog.appel(this);

        super.onFinishInflate();
        adapterAffichageSiPaysage();
    }

    public void creerAffichage(DPartie donnees){
        GLog.appel(this);

        int hauteur = donnees.getTailleGrille().getHauteur();
        int largeur = donnees.getTailleGrille().getLargeur();

        grille.creerGrille(hauteur, largeur);

    }

    @Override
    public void rafraichirAffichage(DPartie donnees) {
        GLog.appel(this);

        grille.afficher(donnees.getGrille());

        rafraichirCommandes();
    }

    @Override
    public void creerCommandes() {
        GLog.appel(this);

        coupIcis = new CCoupIci[grille.getColonnes().length];

        for (int i = 0; i < grille.getColonnes().length; i++) {
            coupIcis[i] = new CCoupIci(i);
        }
    }

    @Override
    public void installerCapteurs() {
        GLog.appel(this);

        grille.installerCapteurs(coupIcis);
    }

    @Override
    public void rafraichirCommandes() {
        GLog.appel(this);

        grille.rafraichirCommandes(coupIcis);
    }


    @Override
    protected void recupererControles() {
        GLog.appel(this);

        texteNomJoueur01 = findViewById(R.id.texte_joueur_un);
        texteNomJoeuur02 = findViewById(R.id.texte_joueur_deux);

        grille = findViewById(R.id.grille);

        adapterAffichageSiPaysage();

    }

    private void adapterAffichageSiPaysage(){
        GLog.appel(this);

        if(! getResources().getBoolean(R.bool.portrait)){

            adapterAffichagePaysage();

        }
    }

    private void adapterAffichagePaysage(){
        GLog.appel(this);

        texteDeHautEnBas(texteNomJoueur01, getResources().getString(R.string.joueur01));
        texteDeHautEnBas(texteNomJoeuur02, getResources().getString(R.string.joueur02));

        texteNomJoueur01.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        texteNomJoeuur02.setTextAlignment(TEXT_ALIGNMENT_CENTER);

    }

    private void texteDeHautEnBas(TextView textView, String texte){
        GLog.appel(this);

        String texteHautEnBas = "";

        if(texte.length() > 0){
            texteHautEnBas += texte.charAt(0);
        }

        for(int i = 1; i < texte.length(); i++){
            texteHautEnBas += "\n" + texte.charAt(i);
        }

        textView.setText(texteHautEnBas);
    }

}
