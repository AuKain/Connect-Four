package ca.cours5b5.nicolasparr.vues.controles;


import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.partie.DCase;
import ca.cours5b5.nicolasparr.global.GLog;

public class VCase extends AppCompatButton {


    public VCase(Context context) {
        super(context);
    }



    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public VCase(Context context, int indiceRangee, int indiceColonne) {
        super(context);

        GLog.appel(this);

        // TP01: afficher les indices
        this.setText(indiceRangee + ", " + indiceColonne);

    }

    public void afficher(DCase dCase) {
        GLog.appel(this);

        if(dCase != null){
            switch(dCase.getCouleur()){

                case BLEU:
                    setBackgroundColor(getResources().getColor(R.color.BLEU, null));
                    break;

                case ROUGE:
                    setBackgroundColor(getResources().getColor(R.color.ROUGE, null));
                    break;

            }

        }else{

            setBackgroundColor(getResources().getColor(R.color.VIDE, null));


        }



    }
}
