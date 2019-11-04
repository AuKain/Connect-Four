package ca.cours5b5.nicolasparr.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import ca.cours5b5.nicolasparr.global.GLog;

public class VGrille extends LinearLayout {

    private ArrayList<VColonne> colonnes;

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        GLog.appel(this);
    }

    public VEntete getEntete(int noColonne) {
        return colonnes.get(noColonne).getEntete();
    }

    public void creerGrille(int hauteur, int largeur) {
        GLog.appel(this);

        colonnes = new ArrayList<>();

        for(int i = 0; i < largeur; i++) {
            colonnes.add(new VColonne(this.getContext(), hauteur, i));

            this.addView(colonnes.get(i), new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        }
    }

    public ArrayList<VColonne> getGrille() {
        return colonnes;
    }
}
