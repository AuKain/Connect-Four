package ca.cours5b5.nicolasparr.vues.controles;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.modeles.MPartie;
import ca.cours5b5.nicolasparr.global.GLog;

public class VEntete extends AppCompatButton {

    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int idColonne;

    public VEntete(Context context, int idColonne) {
        super(context);

        GLog.appel(this);

        this.idColonne = idColonne;

        // TP01: afficher la idColonne pour deboguer
        setText(idColonne + "\n" + getResources().getString(R.string.entete));
        //setText( getResources().getString(R.string.entete) + "\n" + getResources().getString(R.string.entete));

    }

    public void installerCapteur(final MPartie modele) {
        GLog.appel(this);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.appel(this);

                modele.jouerCoupIci(idColonne);
            }
        });


    }
}
