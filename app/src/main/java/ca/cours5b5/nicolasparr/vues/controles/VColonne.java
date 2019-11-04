package ca.cours5b5.nicolasparr.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import ca.cours5b5.nicolasparr.global.GLog;

public class VColonne extends LinearLayout {

    private ArrayList<VCase> cases;
    private VEntete entete;

    public VColonne(Context context) {
        super(context);
    }

    public VColonne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VColonne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VColonne(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public VEntete getEntete() {
        return this.entete;
    }

    public VColonne(Context context, int nbCases, int noColonne) {
        super(context);
        GLog.appel(this);

        this.setOrientation(VERTICAL);

        this.addView(entete = new VEntete(this.getContext(), noColonne), new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 2f));

        cases = new ArrayList<>();

        for (int i = 0; i < nbCases; i++) {
            cases.add(new VCase(this.getContext(), nbCases - i - 1, noColonne));
            this.addView(cases.get(i), new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));
        }

    }

    public ArrayList<VCase> getColonne() {
        return cases;
    }
}
