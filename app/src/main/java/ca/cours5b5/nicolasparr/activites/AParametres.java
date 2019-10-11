package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;

import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PParametres;

public class AParametres extends ActiviteAvecDonnees<DParametres, PParametres> {

    @Override
    protected int getIdPage() {
        return R.id.page_parametres;
    }

    @Override
    protected int getLayoutId(){
        return R.layout.page_parametres;
    }

    @Override
    protected DParametres creerDonnees() {
        return new DParametres();
    }
}