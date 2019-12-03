package ca.cours5b5.nicolasparr.activites;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.donnees.DParametres;
import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.donnees.RetourDonnees;
import ca.cours5b5.nicolasparr.donnees.partie.DPartieLocale;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.global.GUsagerCourant;

public class AAccueil extends ActiviteAvecControles {

    Button boutonConnexion;
    Button boutonPartie;
    Button boutonPartieReseau;
    Button boutonParametres;

    final static int CODE_LOGIN = 122;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        GLog.appel(this);

        if (requestCode == CODE_LOGIN) {
            if (resultCode == RESULT_OK) {
                ajusterBoutonsConnexion();
            }
        }
        GLog.valeurs("Usager", GUsagerCourant.getId());
    }

    private void effectuerConnexion() {
        GLog.appel(this);

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(fournisseursDeConnexion).build();

        this.startActivityForResult(intentionConnexion, CODE_LOGIN);
    }

    private void effectuerDeconnexion() {
        GLog.appel(this);

        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                ajusterBoutonsConnexion();
                GLog.valeurs("Usager", GUsagerCourant.getId());
            }
        });
    }

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

    private void ajusterBoutonsConnexion() {
        GLog.appel(this);

        if (GUsagerCourant.siConnecte()) {
            boutonPartieReseau.setEnabled(true);
            boutonConnexion.setText(R.string.deconnexion);
        } else {
            boutonPartieReseau.setEnabled(false);
            boutonConnexion.setText(R.string.connexion);
        }
    }

    @Override
    protected void installerCapteurs() {
        GLog.appel(this);

        installerCapteurPartieLocale();
        installerCapteurParametres();
        installerCapteurConnexion();
        installerCapteurPartieEnLigne();
    }

    private void installerCapteurConnexion() {
        GLog.appel(this);

        ajusterBoutonsConnexion();

        boutonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.valeurs("Usager", GUsagerCourant.getId());
                if (GUsagerCourant.siConnecte()) {
                    effectuerDeconnexion();
                } else {
                    effectuerConnexion();
                }
            }
        });
    }

    private void installerCapteurPartieLocale(){
        GLog.appel(this);

        boutonPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GLog.appel(this);

                ouvrirPagePartieLocale();
                //effacerPartieCouranteSiNecessairePuisOuvrirPagePartieLocale();

            }
        });
    }

    private void installerCapteurPartieEnLigne() {
        GLog.appel(this);

        ajusterBoutonsConnexion();

        //TODO capteur Partie En Ligne
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

//    private void effacerPartieCouranteSiNecessairePuisOuvrirPagePartieLocale() {
//        GLog.appel(this);
//
//        DParametres dParametres = EntrepotDeDonnees.obtenirDonnees(DParametres.class, null);
//
//        if (!dParametres.getContinuerPartiePrecedente()) {
//
//            effacerPartieCourante();
//
//            DPartieLocale dPartieLocale = EntrepotDeDonnees.obtenirDonnees(DParametres.class, null, repertoireDonnees());
//            dPartieLocale.setTailleGrille(dParametres.getTailleGrille());
//
//        }
//
//        ouvrirPagePartieLocale();
//    }

    private void ouvrirPagePartieLocale() {
        GLog.appel(this);

        Intent intentionPartieLocale = new Intent(this, APartieLocale.class);
        this.startActivity(intentionPartieLocale);

    }

//    private void effacerPartieCourante() {
//        GLog.appel(this);
//
//        File repertoireDonnees = repertoireDonnees();
//
//        EntrepotDeDonnees.effacerDonnees(DPartieLocale.class, repertoireDonnees);
//
//    }

//    private void effacerPartieCourante() {
//        GLog.appel(this);
//
//        File repertoireDonnees = repertoireDonnees();
//
//        EntrepotDeDonnees.effacerDonnees(DPartieLocale.class, repertoireDonnees);
//
//    }

    private void ouvrirPageParametres() {
        GLog.appel(this);

        Intent intentionParametres = new Intent(this, AParametres.class);
        this.startActivity(intentionParametres);

    }
}
