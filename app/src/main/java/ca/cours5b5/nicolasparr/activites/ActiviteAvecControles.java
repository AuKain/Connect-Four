package ca.cours5b5.nicolasparr.activites;


import android.os.Bundle;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class ActiviteAvecControles extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);

        super.onCreate(savedInstanceState);

        recupererControles();
        installerCapteurs();

    }

    protected abstract void recupererControles();
    protected abstract void installerCapteurs();

}
