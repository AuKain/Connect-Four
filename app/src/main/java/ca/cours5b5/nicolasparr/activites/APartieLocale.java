package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DPartieLocale;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartieLocale;
import ca.cours5b5.nicolasparr.vues.pages.PPartieLocale;

public class APartieLocale extends ActiviteAvecModeles<DPartieLocale, MPartieLocale, PPartieLocale> {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getIdPage() {
        GLog.appel(this);
        return R.id.page_partieLocale;
    }

    @Override
    protected Class<DPartieLocale> getClassDonnees() {
        GLog.appel(this);
        return DPartieLocale.class;
    }

    @Override
    protected MPartieLocale creerModele(DPartieLocale donnees, PPartieLocale page) {
        GLog.appel(this);
        return new MPartieLocale(donnees, page);
    }

    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_partie_locale;
    }
}
