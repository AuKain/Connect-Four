package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.global.GLog;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_parametres);
        GLog.valeurs("Bonjour!");
    }

    @Override
    protected int getContentViewId(){
        return R.layout.page_parametres;
    }
}
