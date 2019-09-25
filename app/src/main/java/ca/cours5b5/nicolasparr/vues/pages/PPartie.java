package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class PPartie extends Page {

    public PPartie(Context context) {
        super(context);
    }

    public PPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        GLog.appel(this);
    }
}