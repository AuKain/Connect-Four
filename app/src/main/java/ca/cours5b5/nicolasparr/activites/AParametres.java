package ca.cours5b5.nicolasparr.activites;

import ca.cours5b5.nicolasparr.R;

import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.modeles.MParametres;
import ca.cours5b5.nicolasparr.vues.pages.PParametres;

public class AParametres extends ActiviteAvecModeles<DParametres, MParametres, PParametres> {

    @Override
    protected MParametres creerModele(DParametres donnees, PParametres page) {
        return new MParametres(donnees, page);
    }

    @Override
    protected int getIdPage() {
        return R.id.page_parametres;
    }

    @Override
    protected Class<DParametres> getClassDonnees() {
        return DParametres.class;
    }

    @Override
    protected int getLayoutId(){
        return R.layout.page_parametres;
    }

}