package ca.cours5b5.nicolasparr.vues.controles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.commandes.CCoupIci;
import ca.cours5b5.nicolasparr.donnees.partie.DCase;
import ca.cours5b5.nicolasparr.donnees.partie.DColonne;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.modeles.MPartie;

public class VColonne extends LinearLayout {

    private VEntete entete;
    private VCase[] cases;

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


    public VColonne(Context context, int hauteur, int indiceColonne) {
        super(context);

        GLog.appel(this);

        this.cases = new VCase[hauteur];

        creerColonne(hauteur, indiceColonne);
    }

    public VEntete getEntete() {
        return entete;
    }

    private void creerColonne(int hauteur, int indiceColonne){
        GLog.appel(this);

        this.setOrientation(LinearLayout.VERTICAL);

        ajouterEntete(indiceColonne);

        ajouterCases(hauteur, indiceColonne);
    }


    private void ajouterCases(int hauteur, int indiceColonne) {
        GLog.appel(this);

        LayoutParams paramsCase = getParamsCase();

        // Ajouter les cases à l'envers!
        for(int indiceRangee = hauteur - 1; indiceRangee >= 0; indiceRangee--){
            VCase vCase = new VCase(getContext(), indiceRangee, indiceColonne);
            this.addView(vCase, paramsCase);

            cases[indiceRangee] = vCase;
        }
    }

    private LayoutParams getParamsCase() {
        GLog.appel(this);

        LayoutParams paramsCase = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f);

        paramsCase.leftMargin = getResources().getInteger(R.integer.marge_case);
        paramsCase.topMargin = getResources().getInteger(R.integer.marge_case);
        paramsCase.rightMargin = getResources().getInteger(R.integer.marge_case);
        paramsCase.bottomMargin = getResources().getInteger(R.integer.marge_case);
        return paramsCase;
    }


    private void ajouterEntete(int indiceColonne) {
        GLog.appel(this);

        entete = new VEntete(getContext(), indiceColonne);

        LayoutParams layoutParams = getParamsEntete();

        this.addView(entete, layoutParams);
    }

    private LayoutParams getParamsEntete() {
        GLog.appel(this);

        LayoutParams layoutParams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                2f);

        layoutParams.leftMargin = getResources().getInteger(R.integer.marge_case);
        layoutParams.rightMargin = getResources().getInteger(R.integer.marge_case);
        return layoutParams;
    }


    public void installerCapteur(CCoupIci coupIci) {
        GLog.appel(this);

        entete.installerCapteur(coupIci);

    }

        public void afficher(DColonne dColonne) {
        GLog.appel(this);

        if(dColonne != null){

            List<DCase> casesDonnees = dColonne.getCases();

            for(int i = 0; i < casesDonnees.size(); i++) {
                cases[i].afficher(casesDonnees.get(i));
            }
        }
    }

    public void rafraichirCommande(CCoupIci coupIci) {
        GLog.appel(this);

        entete.setEnabled(coupIci.siExecutable());
    }
}
