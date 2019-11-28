package ca.cours5b5.nicolasparr.donnees;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ca.cours5b5.nicolasparr.donnees.partie.RetourChargement;
import ca.cours5b5.nicolasparr.donnees.partie.RetourDonnees;
import ca.cours5b5.nicolasparr.global.GLog;
import java.util.HashMap;
import java.util.Map;

public class EntrepotDeDonnees {

    private static Gson gson = new GsonBuilder().create();
    private static final Map<Class<? extends Donnees>, Donnees> entrepot = new HashMap<>();
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
        //TODO Nom de la collection selon la classe de données
        return null;
    }

    private static String idDoccument() {
        //TODO Nom du document (utiliser p.ex. l'id de l'usager courant)
        return null;
    }

    private static DocumentReference referenceDocument (Class<? extends Donnees> classeDonnees) {
        //TODO Une référence au document Firestore
        return null;
    }

    private static <D extends Donnees> void sauvegarderDonneesSurServeur (D donnees) {
        //TODO Sauvegarder sur Firestore
    }

    private static <D extends Donnees> void reagirDonneesChargees (RetourChargement<D> retourChargement, @Nullable D donnees) {
        //TODO Appeler le listener RetourChargement. ATTENTION: il faut vérifier si le documentSnapshot existe sur le serveur
    }

    private static <D extends Donnees> void reagirDocumentCharge (Class<D> classeDonnees, RetourChargement<D> retourChargement, DocumentSnapshot documentSnapshot) {
        //TODO Appeler le listener RetourChargement. ATTENTION: il faut véridifer si le documentSnapshot existe sur le serveur
    }

    private static <D extends Donnees> void installerCapteursServeur (final Class<D> classeDonees, final RetourChargement<D> retourChargement, Task<DocumentSnapshot> promessesServeur) {
        //TODO Installer les listeners sur le serveur:
        // - en cas de succès
        // - en cas d'échec
    }

    private static <D extends Donnees> void chargerDonneesDuServeur (final Class<D> classeDonnees, final RetourChargement<D> retourChargement) {
        //TODO Obtenir une référence au document sur le serveur
        // .
        // Installer les listeners
    }

    public static <D extends Donnees> D obtenirDonnees(Class<D> classeDonnees, final RetourDonnees<D> retourDonnees){

        //TODO Appeler chargerDonneesDuServeur et réagir correctement au RetourChargement

        GLog.appel(EntrepotDeDonnees.class);

        return null;
    }
}
