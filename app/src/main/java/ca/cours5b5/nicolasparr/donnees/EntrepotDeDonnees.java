package ca.cours5b5.nicolasparr.donnees;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.global.GUsagerCourant;

public class EntrepotDeDonnees {

    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    private static <D extends Donnees> D creerDonnees(Class<D> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        D donnees;

        try {

            donnees = classeDonnees.newInstance();

        } catch (IllegalAccessException | InstantiationException e) {

            throw new RuntimeException("Erreur d'instantiation pour " + classeDonnees.getSimpleName());
        }

        return donnees;

    }

    private static String nomCollection(Class<? extends Donnees> classeDonnees) {
        return classeDonnees.getSimpleName();
    }

    private static String idDoccument() {
        return GUsagerCourant.getId();
    }

    private static DocumentReference referenceDocument(Class<? extends Donnees> classeDonnees) {
        return firestore.collection(nomCollection(classeDonnees)).document(idDoccument());
    }

    public static <D extends Donnees> void sauvegarderDonneesSurServeur (D donnees) {
        referenceDocument(donnees.getClass()).set(donnees);
    }

    private static <D extends Donnees> void reagirDonneesChargees(RetourChargement<D> retourChargement, @Nullable D donnees) {

        if (donnees != null) {
            retourChargement.chargementReussi(donnees);
        } else {
            retourChargement.chargementEchoue();
        }
    }

    private static <D extends Donnees> void reagirDocumentCharge(Class<D> classeDonnees, RetourChargement<D> retourChargement, DocumentSnapshot documentSnapshot) {

        if (documentSnapshot.exists()) {
            reagirDonneesChargees(retourChargement, documentSnapshot.toObject(classeDonnees));
        } else {
            retourChargement.chargementEchoue();
        }
    }

    private static <D extends Donnees> void installerCapteursServeur(final Class<D> classeDonees, final RetourChargement<D> retourChargement, Task<DocumentSnapshot> promessesServeur) {

        promessesServeur.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                reagirDocumentCharge(classeDonees, retourChargement, documentSnapshot);
            }
        });

        promessesServeur.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //FIXME
            }
        });
    }

    private static <D extends Donnees> void chargerDonneesDuServeur(final Class<D> classeDonnees, final RetourChargement<D> retourChargement) {
        installerCapteursServeur(classeDonnees, retourChargement, referenceDocument(classeDonnees).get());
    }

    public static <D extends Donnees> void obtenirDonnees(final Class<D> classeDonnees, final RetourDonnees<D> retourDonnees){

        chargerDonneesDuServeur(classeDonnees, new RetourChargement<D>() {
            @Override
            public void chargementReussi(D donnees) {
                retourDonnees.recevoirDonnees(donnees);
            }

            @Override
            public void chargementEchoue() {
                retourDonnees.recevoirDonnees(creerDonnees(classeDonnees));
            }
        });
    }
}
