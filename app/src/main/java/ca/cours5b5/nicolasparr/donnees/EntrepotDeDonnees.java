package ca.cours5b5.nicolasparr.donnees;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ca.cours5b5.nicolasparr.global.GLog;

public class EntrepotDeDonnees {

    static Map<Class<? extends Donnees>, Donnees> donneesParId = new HashMap<>();
    private static Gson gson = new GsonBuilder().create();

    public static <D extends Donnees> D obtenirDonnees(Class<D> classeDonnees, Bundle etat) {

        if (siDonneesSontDansEtat(classeDonnees, etat)) {

            return donneesDansEtat(classeDonnees, etat);
        } else if (siDonneesSontDansEntrepot(classeDonnees)) {

            return donneesDansEntrepot(classeDonnees);
        } else {

            D donnees = creerDonnees(classeDonnees);
            entreposerDonnees(donnees);
            return donnees;
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
    }

    public static <D extends Donnees> boolean siDonneesSontDansEtat(Class<? extends Donnees> classeDonnees, Bundle etat) {

        GLog.valeurs(classeDonnees);
        GLog.valeurs(etat);

        try {

            return etat.containsKey(clePourClasseDonnees(classeDonnees));
        } catch (NullPointerException e) {

            return false;
        }
    }

    public static <D extends Donnees> D donneesDansEtat (Class<D> classeDonnees, Bundle etat) {
        return gson.fromJson(etat.getString(clePourClasseDonnees(classeDonnees)), classeDonnees);
    }

    private static String clePourClasseDonnees(Class<? extends Donnees> classeDonnees) {
        return classeDonnees.getName();
    }
}
