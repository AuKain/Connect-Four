package ca.cours5b5.nicolasparr.donnees;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ca.cours5b5.nicolasparr.global.GLog;

public class EntrepotDeDonnees {

    static Map<Class<? extends Donnees>, Donnees> donneesParId = new HashMap<>();
    private static Gson gson = new GsonBuilder().create();

    public static <D extends Donnees> D obtenirDonnees(Class<D> classeDonnees, Bundle etat, File repertoireDonnees) {

        if (siDonneesSontDansEtat(classeDonnees, etat)) {

            return donneesDansEtat(classeDonnees, etat);
        } else if (siDonneesSontSurDisque(classeDonnees, repertoireDonnees)) {

            return donneesSurDisque(classeDonnees, repertoireDonnees);
        } else if (siDonneesSontDansEntrepot(classeDonnees)) {

            return donneesDansEntrepot(classeDonnees);
        } else {

            D donnees = creerDonnees(classeDonnees);
            entreposerDonnees(donnees);
            return donnees;
        }
    }

    private static String nomFichierPourClasseDonnees(Class<? extends Donnees> classeDonnees) {
        return classeDonnees.getSimpleName();
    }

    private static File fichierDonnees(Class<? extends Donnees> classeDonnees, File repertoireDonnees) {

        return new File(repertoireDonnees, nomFichierPourClasseDonnees(classeDonnees));
    }

    private static boolean siDonneesSontSurDisque(Class<? extends Donnees> classeDonnees, File repertoireDonnees) {

        return fichierDonnees(classeDonnees, repertoireDonnees).exists();
    }

    private static <D extends Donnees> D donneesSurDisque(Class<D> classeDonnees, File repertoireDonnees) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichierDonnees(classeDonnees, repertoireDonnees)));

            D donnees = gson.fromJson(reader.readLine(), classeDonnees);
            reader.close();

            GLog.valeurs("Données lues sur disque: ", gson.toJson(donnees));

            return donnees;

        } catch (IOException e) {

            return null;
        }
    }

    public static <D extends Donnees> void sauvegarderSurDisque(D donnees, File repertoireDonnees) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichierDonnees(donnees.getClass(), repertoireDonnees)));

            writer.write(gson.toJson(donnees));
            writer.close();

            GLog.valeurs("Données sauvegardées sur le disque: ", gson.toJson(donnees));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <D extends Donnees> D creerDonnees(Class<D> classeDonnees) {
        try {
            return classeDonnees.newInstance();
        } catch (IllegalAccessException | InstantiationException e ) {
            throw new RuntimeException(e);
        }
    }

    private static <D extends Donnees> D donneesDansEntrepot(Class<? extends Donnees> classeDonnees) {
        return (D) donneesParId.get(classeDonnees);
    }

    private static boolean siDonneesSontDansEntrepot(Class<? extends Donnees> classeDonnees) {
        return donneesParId.get(classeDonnees) != null;
    }

    private static <D extends Donnees> void entreposerDonnees(D donnees) {
        donneesParId.put(donnees.getClass(), donnees);
    }

    public static <D extends Donnees> void sauvegarderDonnees(D donnees, Bundle outState) {

        outState.putString(clePourClasseDonnees(donnees.getClass()), gson.toJson(donnees));
        GLog.valeurs("Données sauvegardées: ", donnees.getClass(), gson.toJson(donnees));
    }

    public static <D extends Donnees> boolean siDonneesSontDansEtat(Class<? extends Donnees> classeDonnees, Bundle etat) {
        try {

            return etat.containsKey(clePourClasseDonnees(classeDonnees));
        } catch (NullPointerException e) {

            return false;
        }
    }

    public static <D extends Donnees> D donneesDansEtat (Class<D> classeDonnees, Bundle etat) {
        D contenuJson = gson.fromJson(etat.getString(clePourClasseDonnees(classeDonnees)), classeDonnees);

        GLog.valeurs("Données chargées: ", classeDonnees, gson.toJson(contenuJson));
        return contenuJson;
    }

    private static String clePourClasseDonnees(Class<? extends Donnees> classeDonnees) {
        return classeDonnees.getName();
    }
}
