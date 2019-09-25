package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.global.GLog;

public class APartieLocale extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_partie_locale);
    }

    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_partie_locale;
    }
}
