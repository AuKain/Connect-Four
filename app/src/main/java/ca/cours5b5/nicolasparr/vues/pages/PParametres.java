package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Switch;
import android.widget.CheckBox;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MParametres;

public class PParametres extends PageAvecModeles<DParametres, MParametres> {

    CheckBox checkBoxS;
    CheckBox checkBoxM;
    CheckBox checkBoxL;

    Switch switchResume;

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

        switch (donnees.getTailleGrille()) {
            case PETITE:
                checkBoxS.setChecked(true);
                checkBoxM.setChecked(false);
                checkBoxL.setChecked(false);
                break;
            case MOYENNE:
                checkBoxS.setChecked(false);
                checkBoxM.setChecked(true);
                checkBoxL.setChecked(false);
                break;
            case GRANDE:
                checkBoxS.setChecked(false);
                checkBoxM.setChecked(false);
                checkBoxL.setChecked(true);
                break;
        }

        switchResume.setChecked(donnees.isContinuerPartiePrec());
    }

    @Override
    public void installerCapteurs(final MParametres modele) {
        GLog.appel(this);

        checkBoxS.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                modele.setCheckPetit(checkBoxS, checkBoxM, checkBoxL);
            }
        });
        checkBoxM.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                modele.setCheckMoyen(checkBoxS, checkBoxM, checkBoxL);
            }
        });
        checkBoxL.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                modele.setCheckGrand(checkBoxS, checkBoxM, checkBoxL);
            }
        });
        switchResume.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                modele.setSwitchContinuer(switchResume);
            }
        });
    }

    @Override
    public void rafraichirAffichage(DParametres donnees) {
        GLog.appel(this);

        switch (donnees.getTailleGrille()) {
            case PETITE:
                checkBoxS.setChecked(true);
                checkBoxM.setChecked(false);
                checkBoxL.setChecked(false);
                break;
            case MOYENNE:
                checkBoxS.setChecked(false);
                checkBoxM.setChecked(true);
                checkBoxL.setChecked(false);
                break;
            case GRANDE:
                checkBoxS.setChecked(false);
                checkBoxM.setChecked(false);
                checkBoxL.setChecked(true);
                break;
        }

        switchResume.setChecked(donnees.isContinuerPartiePrec());
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        checkBoxS = findViewById(R.id.checkBoxS);
        checkBoxM = findViewById(R.id.checkBoxM);
        checkBoxL = findViewById(R.id.checkBoxL);
        switchResume = findViewById(R.id.switchResume);

        GLog.valeurs(checkBoxS, checkBoxM, checkBoxL, switchResume);
    }
}
