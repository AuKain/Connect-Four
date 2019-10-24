package ca.cours5b5.nicolasparr.modeles;

import android.widget.CheckBox;
import android.widget.Switch;

import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PParametres;

public class MParametres extends Modele<DParametres, PParametres> {



    public MParametres(DParametres donnees, PParametres page) {
        super(donnees, page);
    }

    public void setCheckPetit(CheckBox checkPetit, CheckBox checkMoyen, CheckBox checkGrand) {
        GLog.appel(this);

        donnees.setTailleGrille(ETailleGrille.PETITE);
        checkPetit.setChecked(true);
        checkMoyen.setChecked(false);
        checkGrand.setChecked(false);
    }

    public void setCheckMoyen(CheckBox checkPetit, CheckBox checkMoyen, CheckBox checkGrand) {
        GLog.appel(this);

        donnees.setTailleGrille(ETailleGrille.MOYENNE);
        checkPetit.setChecked(false);
        checkMoyen.setChecked(true);
        checkGrand.setChecked(false);
    }

    public void setCheckGrand(CheckBox checkPetit, CheckBox checkMoyen, CheckBox checkGrand) {
        GLog.appel(this);

        donnees.setTailleGrille(ETailleGrille.GRANDE);
        checkPetit.setChecked(false);
        checkMoyen.setChecked(false);
        checkGrand.setChecked(true);
    }

    public void setSwitchContinuer(Switch switchContinuer) {
        GLog.appel(this);

        donnees.setContinuerPartiePrec(switchContinuer.isChecked());
    }
}
