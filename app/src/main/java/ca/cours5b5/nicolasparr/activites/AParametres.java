package ca.cours5b5.nicolasparr.activites;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MParametres;
import ca.cours5b5.nicolasparr.vues.pages.PParametres;



public class AParametres extends ActiviteAvecModeles<DParametres, MParametres, PParametres> {

    @Override
    protected int getLayoutId() {
        GLog.appel(this);

        return R.layout.page_parametres;
    }

    @Override
    protected int getIdPage() {
        GLog.appel(this);

        return R.id.page_parametres;
    }

    @Override
    protected Class getClassDonnees() {
        GLog.appel(this);

        return DParametres.class;
    }

    @Override
    protected MParametres creerModele(DParametres donnees, PParametres page) {
        GLog.appel(this);

        return new MParametres(donnees, page);
    }

}
