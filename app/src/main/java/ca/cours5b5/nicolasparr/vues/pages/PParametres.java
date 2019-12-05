package ca.cours5b5.nicolasparr.vues.pages;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.commandes.CContinuerPartie;
import ca.cours5b5.nicolasparr.commandes.CTailleGrille;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MParametres;

import static ca.cours5b5.nicolasparr.enumerations.ETailleGrille.GRANDE;
import static ca.cours5b5.nicolasparr.enumerations.ETailleGrille.MOYENNE;
import static ca.cours5b5.nicolasparr.enumerations.ETailleGrille.PETITE;

public class PParametres extends PageAvecModeles<DParametres, MParametres> {

    private Switch switchContinuerPartie;

    private CheckBox checkPetite;
    private CheckBox checkMoyenne;
    private CheckBox checkGrande;

    private CTailleGrille cTaillePetite;
    private CTailleGrille cTailleMoyenne;
    private CTailleGrille cTailleGrande;
    private CContinuerPartie cContinuerPartie;

    public PParametres(Context context) {
        super(context);
    }

    public PParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void creerAffichage(DParametres donnees) {
        GLog.appel(this);
    }

    @Override
    public void rafraichirAffichage(DParametres donnees) {
        GLog.appel(this);

        rafraichirTailleGrille(donnees.getTailleGrille());

        rafraichirContinuer(donnees.getContinuerPartiePrecedente());

        rafraichirCommandes();
    }

    @Override
    public void creerCommandes() {
        cContinuerPartie = new CContinuerPartie(switchContinuerPartie.isChecked());

        cTaillePetite = new CTailleGrille(PETITE);
        cTailleMoyenne = new CTailleGrille(MOYENNE);
        cTailleGrande = new CTailleGrille(GRANDE);
    }

    @Override
    public void rafraichirCommandes() {

        checkPetite.setClickable(cTaillePetite.siExecutable());
        checkMoyenne.setClickable(cTailleMoyenne.siExecutable());
        checkGrande.setClickable(cTailleGrande.siExecutable());

        cContinuerPartie = new CContinuerPartie(switchContinuerPartie.isChecked());
    }

    @Override
    public void installerCapteurs() {
        GLog.appel(this);

        checkPetite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GLog.appel(this);

                cTaillePetite.executer();
            }
        });

        checkMoyenne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GLog.appel(this);

                cTailleMoyenne.executer();
            }
        });

        checkGrande.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GLog.appel(this);

                cTailleGrande.executer();
            }
        });

        switchContinuerPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.appel(this);

                cContinuerPartie.executer();
            }
        });

    }

    private void rafraichirTailleGrille(ETailleGrille tailleGrille) {
        GLog.appel(this);

        switch (tailleGrille) {

            case PETITE:
                checkPetite.setChecked(true);
                checkMoyenne.setChecked(false);
                checkGrande.setChecked(false);
                break;

            case MOYENNE:
                checkPetite.setChecked(false);
                checkMoyenne.setChecked(true);
                checkGrande.setChecked(false);
                break;

            case GRANDE:
                checkPetite.setChecked(false);
                checkMoyenne.setChecked(false);
                checkGrande.setChecked(true);
                break;

        }
    }


    private void rafraichirContinuer(boolean siContinuerPartiePrecedente) {
        GLog.appel(this);

        switchContinuerPartie.setChecked(siContinuerPartiePrecedente);

    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        switchContinuerPartie = findViewById(R.id.switch_continuer_partie);

        checkPetite = findViewById(R.id.check_petite_grille);
        checkMoyenne = findViewById(R.id.check_moyenne_grille);
        checkGrande = findViewById(R.id.check_grande_grille);

        GLog.valeurs(switchContinuerPartie, checkPetite, checkMoyenne, checkGrande);
    }
}
