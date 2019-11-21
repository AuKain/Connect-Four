package ca.cours5b5.nicolasparr.enumerations;

import android.content.Context;
import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.global.GLog;

public enum ECouleur {

    BLEU,
    ROUGE;

    public String getNomTraduit(Context context){
        GLog.appel(this);

        String nomTraduit = null;

        switch(this){

            case BLEU:

                nomTraduit = context.getResources().getString(R.string.bleu);
                break;

            case ROUGE:

                nomTraduit = context.getResources().getString(R.string.rouge);
                break;

        }

        return nomTraduit;

    }
}
