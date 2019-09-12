package ca.cours5b5.nicolasparr.activites;

import android.widget.Button;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.global.GLog;

public class AAccueil extends ActiviteAvecControles {

    Button buttonConnection;
    Button buttonPlay;
    Button buttonOnline;
    Button buttonSettings;

    @Override
    protected void recupererControles() {

        GLog.appel(this);

        buttonConnection = findViewById(R.id.buttonConnection);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonOnline = findViewById(R.id.buttonOnline);
        buttonSettings = findViewById(R.id.buttonSettings);

        GLog.valeurs(buttonConnection, buttonPlay, buttonOnline, buttonSettings);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.page_accueil;
    }
}
