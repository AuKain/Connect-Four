package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.donnees.partie.DPartieLocale;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartieLocale;
import ca.cours5b5.nicolasparr.vues.pages.PPartieLocale;

public class APartieLocale extends APartie<DPartieLocale, MPartieLocale, PPartieLocale> {

    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_partie_locale;
    }

    @Override
    protected int getIdPage() {
        GLog.appel(this);
        return R.id.page_partie_locale;
    }

    @Override
    protected Class<DPartieLocale> getClassDonnees() {
        GLog.appel(this);

        return DPartieLocale.class;
    }

    @Override
    protected void creerModele(DPartieLocale donnees, PPartieLocale page) {
        GLog.appel(this);

        new MPartieLocale(donnees, page);
    }
}
