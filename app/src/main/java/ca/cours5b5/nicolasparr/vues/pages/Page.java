package ca.cours5b5.nicolasparr.vues.pages;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.Modele;

public abstract class Page extends ConstraintLayout {

    public Page(Context context) {
        super(context);
    }

    public Page(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Page(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        GLog.appel(this);
        super.onFinishInflate();

        recupererControles();

    }

    protected abstract void recupererControles();

}
