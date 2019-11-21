package ca.cours5b5.nicolasparr.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.io.File;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.donnees.partie.DPartieLocale;
import ca.cours5b5.nicolasparr.global.GLog;

public class AAccueil extends ActiviteAvecControles {

    Button boutonConnexion;
    Button boutonPartie;
    Button boutonPartieReseau;
    Button boutonParametres;


    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_accueil;
    }

    @Override
    protected void recupererControles() {
        GLog.appel(this);

        boutonConnexion = findViewById(R.id.bouton_connexion);
        boutonPartie = findViewById(R.id.bouton_partie);
        boutonPartieReseau = findViewById(R.id.bouton_partie_reseau);
        boutonParametres = findViewById(R.id.bouton_parametres);

        GLog.valeurs(boutonConnexion, boutonPartie, boutonPartieReseau, boutonParametres);

    }

    @Override
    protected void installerCapteurs() {
        GLog.appel(this);

        installerCapteurPartieLocale();
        installerCapteurParametres();
    }

    private void installerCapteurPartieLocale(){
        GLog.appel(this);

        boutonPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.appel(this);

                effacerPartieCouranteSiNecessairePuisOuvrirPagePartieLocale();

            }
        });
    }

    private void installerCapteurParametres(){
        GLog.appel(this);
        
        boutonParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.appel(this);

                ouvrirPageParametres();
            }
        });
    }

        private void effacerPartieCouranteSiNecessairePuisOuvrirPagePartieLocale() {
            GLog.appel(this);

            DParametres dParametres = EntrepotDeDonnees.obtenirDonnees(DParametres.class, null, repertoireDonnees());

            if (!dParametres.siContinuerPartiePrecedente()) {

                effacerPartieCourante();

                DPartieLocale dPartieLocale = EntrepotDeDonnees.obtenirDonnees(DPartieLocale.class, null, repertoireDonnees());
                dPartieLocale.setTailleGrille(dParametres.getTailleGrille());

            }

            ouvrirPagePartieLocale();

        }


    private void ouvrirPagePartieLocale(){
        GLog.appel(this);

        Intent intentionPartieLocale = new Intent(this, APartieLocale.class);
        this.startActivity(intentionPartieLocale);

    }

    private void effacerPartieCourante() {
        GLog.appel(this);

        File repertoireDonnees = repertoireDonnees();

        EntrepotDeDonnees.effacerDonnees(DPartieLocale.class, repertoireDonnees);

    }

    private void ouvrirPageParametres(){
        GLog.appel(this);

        Intent intentionParametres = new Intent(this, AParametres.class);
        this.startActivity(intentionParametres);

    }
}
