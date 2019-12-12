package ca.cours5b5.nicolasparr.donnees;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.global.GUsagerCourant;

public class EntrepotDeDonnees {

    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    private static Map<Class<? extends Donnees>, ListenerRegistration> observateur = new HashMap<>();


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
        GLog.appel(EntrepotDeDonnees.class);

        return classeDonnees.getSimpleName();
    }

    private static String idDocument() {
        return GUsagerCourant.getId();
    }

    private static DocumentReference referenceDocument(Class<? extends Donnees> classeDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        return firestore.collection(nomCollection(classeDonnees)).document(idDocument());
    }

    public static <D extends Donnees> void sauvegarderDonneesSurServeur (D donnees) {
        GLog.appel(EntrepotDeDonnees.class);

        referenceDocument(donnees.getClass()).set(donnees);
    }

    private static <D extends Donnees> void reagirDonneesChargees(RetourChargement<D> retourChargement, @Nullable D donnees) {
        GLog.appel(EntrepotDeDonnees.class);

        if (donnees != null) {
            retourChargement.chargementReussi(donnees);
        } else {
            retourChargement.chargementEchoue();
        }
    }

    private static <D extends Donnees> void reagirDocumentCharge(Class<D> classeDonnees, RetourChargement<D> retourChargement, DocumentSnapshot documentSnapshot) {
        GLog.appel(EntrepotDeDonnees.class);

        if (documentSnapshot.exists()) {
            reagirDonneesChargees(retourChargement, documentSnapshot.toObject(classeDonnees));
        } else {
            retourChargement.chargementEchoue();
        }
    }

    private static <D extends Donnees> void installerCapteursServeur(final Class<D> classeDonees, final RetourChargement<D> retourChargement, Task<DocumentSnapshot> promessesServeur) {
        GLog.appel(EntrepotDeDonnees.class);

        promessesServeur.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                reagirDocumentCharge(classeDonees, retourChargement, documentSnapshot);
            }
        });

        promessesServeur.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Rien on failure pour l'instant
            }
        });
    }

    private static <D extends Donnees> void chargerDonneesDuServeur(final Class<D> classeDonnees, final RetourChargement<D> retourChargement) {
        GLog.appel(EntrepotDeDonnees.class);

        installerCapteursServeur(classeDonnees, retourChargement, referenceDocument(classeDonnees).get());
    }

    public static <D extends Donnees> void obtenirDonnees(final Class<D> classeDonnees, final RetourDonnees<D> retourDonnees){
        GLog.appel(EntrepotDeDonnees.class);

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

    private static <D extends Donnees> void memoriserObservateur(Class<D> classeDonnees, ListenerRegistration listenerRegistration) {
        GLog.appel(EntrepotDeDonnees.class);

        observateur.put(classeDonnees, listenerRegistration);
    }

    public static <D extends Donnees> void effacerObservateur(final Class<D> classeDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        if (observateur.containsValue(classeDonnees)) {

            observateur.get(classeDonnees).remove();

        }
    }

    private static <D extends Donnees> void observerUnDocument(Class<D> classeDonnees, Observateur<D> observateurClient, DocumentChange documentChange) {
        GLog.appel(EntrepotDeDonnees.class);
        /*
         * appeler l'observateurClient correctement
         * selon le type du documentChange: ADDED ou MODIFIED
         */

        switch (documentChange.getType()) {

            case ADDED:

                observateurClient.notifierNouvellesDonnees(documentChange.getDocument().toObject(classeDonnees));
                break;

            case MODIFIED:

                observateurClient.notifierModifierDonnees(documentChange.getDocument().toObject(classeDonnees));
                break;

            case REMOVED:

                //Rien faire dans le contexte de cette application
                break;
        }
    }

    private static <D extends Donnees> void observerDocumentsExistants(Class<D> classeDonnees, Observateur<D> observateurClient, QuerySnapshot queryDocumentSnapshots) {
        GLog.appel(EntrepotDeDonnees.class);

        for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {

            observerUnDocument(classeDonnees, observateurClient, documentChange);
        }
    }

    private static <D extends Donnees> void observerDocumentsOuCreerNouveau(Class<D> classeDonnees, Observateur<D> observateurClient, QuerySnapshot queryDocumentSnapshots) {
        GLog.appel(EntrepotDeDonnees.class);
        /*
         *
         *  Si la requête est vide:
         *    - créer de nouvelles données et appeler l'observateurClient
         *  Sinon
         *   - appeler observerDocumentsExistants
         *
         */

        if (queryDocumentSnapshots.isEmpty()) {

            observateurClient.nouveau(creerDonnees(classeDonnees));
        } else {

            observerDocumentsExistants(classeDonnees, observateurClient, queryDocumentSnapshots);
        }
    }

    private static <D extends Donnees> EventListener<QuerySnapshot> creerObservateurServeur(final Class<D> classeDonnees, final Observateur<D> observateurClient) {
        GLog.appel(EntrepotDeDonnees.class);
        /*
         * Créer et retourner un observateur serveur qui:
         *    - verifie si le queryDocumentSnapshots est null
         *    - appelle les bonnes méthodes
         *
         */

        return new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {

                observerDocumentsOuCreerNouveau(classeDonnees, observateurClient, queryDocumentSnapshots);
            }
        };
    }

    private static <D extends Donnees> Query creerRequete(Class<D> classeDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        return firestore.collection(nomCollection(classeDonnees)).whereEqualTo(FieldPath.documentId(), idDocument());
    }

    private static ListenerRegistration ajouterObservateurServeur(Query requete, EventListener<QuerySnapshot> observateurServeur) {
        GLog.appel(EntrepotDeDonnees.class);

        return requete.addSnapshotListener(observateurServeur);
    }

    public static <D extends Donnees> void observerDonnees(final Class<D> classeDonnees, final Observateur<D> observateurClient) {
        GLog.appel(EntrepotDeDonnees.class);

        effacerObservateur(classeDonnees);

        memoriserObservateur(classeDonnees, ajouterObservateurServeur(creerRequete(classeDonnees), creerObservateurServeur(classeDonnees, observateurClient)));
    }
}
