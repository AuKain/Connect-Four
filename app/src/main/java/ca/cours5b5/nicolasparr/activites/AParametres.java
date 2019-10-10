package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;

import ca.cours5b5.nicolasparr.global.GLog;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_parametres);
        GLog.valeurs("Est-ce qu'on est en portrait?, " + !this.getResources().getBoolean(R.bool.land));
    }

    @Override
    protected int getLayoutId(){
        return R.layout.page_parametres;
    }
}