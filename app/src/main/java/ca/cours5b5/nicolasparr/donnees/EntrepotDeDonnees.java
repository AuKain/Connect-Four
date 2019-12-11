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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.global.GUsagerCourant;

public class EntrepotDeDonnees {

    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    private static Map<Class<? extends Donnees>, ListenerRegistration> observateur;


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
                //Rien on failure pour l'instant
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

    private static <D extends Donnees> void memoriserObservateur(Class<D> classeDonnees, ListenerRegistration listenerRegistration) {
        /*
         * TODO Stoquer l'observateur serveur dans le Map
         */
    }

    public static <D extends Donnees> void effacerObservateur(final Class<Donnees> classeDonnees) {
        /*
         * TODO Annuler l'observateur serveur (s'il existe dans votre Map)
         */
    }

    private static <D extends Donnees> void observerUnDocument(Class<D> classeDonnees, Observateur<D> observateurClient, DocumentChange documentChange) {
        /*
         * TODO appeler l'observateurClient correctement
         *  selon le type du documentChange: ADDED ou MODIFIED
         */
    }

    private static <D extends Donnees> void observerDocumentsExistants(Class<D> classeDonnees, Observateur<D> observateurClient, QueryDocumentSnapshot queryDocumentSnapshot) {
        /*
         * TODO Observer tous les documents de queryDocumentSnapshots
         */
    }

    private static <D extends Donnees> void observerDocumentsOuCreerNouveau(Class<D> classeDonnees, Observateur<D> observateurClient, QueryDocumentSnapshot queryDocumentSnapshot) {
        /*
         * TODO
         *  Si la requête est vide:
         *    - créer de nouvelles données et appeler l'observateurClient
         *  Sinon
         *   - appeler observerDocumentsExistants
         *
         */
    }

    private static <D extends Donnees> EventListener<QuerySnapshot> creerObservateurServeur(final Class<D> classeDonnees, final Observateur<D> observateurClient) {
        /*
         * TODO Créer et retourner un observateur serveur qui:
         *    - verifie si le queryDocumentSnapshots est null
         *    - appelle les bonnes méthodes
         *
         */

        return null;
    }

    private static <D extends Donnees> Query creerRequete(Class<D> classeDonnees) {
        /*
         * TODO Créer la requête où
         *    - FieldPath.documentId est égal à idDocument()
         *
         */

        return null;
    }

    private static ListenerRegistration ajouterObservateurServeur(Query requete, EventListener<QuerySnapshot> observateurServeur) {
        /*
         * TODO Ajouter le listener / observateurServeur
         */

        return null;
    }

    public static <D extends Donnees> void observerDonnees(final Class<D> classeDonnees, final Observateur<D> observateurClient) {
        /*
         * TODO Effacer l'observateur précédent **IMPORTANT**
         *  Créer la requête
         *  Créer l'observateur serveur
         *  Ajouter l'observateur serveur
         *  Mémoriser l'observateur server
         *
         */
    }
}
