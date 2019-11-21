package ca.cours5b5.nicolasparr.donnees;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ca.cours5b5.nicolasparr.global.GLog;
import java.util.HashMap;
import java.util.Map;

public class EntrepotDeDonnees {

    private static Gson gson = new GsonBuilder().create();
    private static final Map<Class<? extends Donnees>, Donnees> entrepot = new HashMap<>();

    public static <D extends Donnees> D obtenirDonnees(Class<D> classeDonnees,
                                                       Bundle etat,
                                                       File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        D donnees;

        if(siDonneesSontDansEntrepot(classeDonnees)) {

            donnees = donneesDansEntrepot(classeDonnees);

        }else{

            donnees = nouvellesDonnees(classeDonnees, etat, repertoireDonnees);
            entreposerDonnees(donnees);

        }

        return donnees;
    }

    public static <D extends Donnees> D nouvellesDonnees(Class<D> classeDonnees,
                                                       Bundle etat,
                                                       File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        D donnees;

        if(siDonneesSontDansEtat(classeDonnees, etat)) {

            donnees = donneesDansEtat(classeDonnees, etat);

        }else if(siDonneesSontSurDisque(classeDonnees, repertoireDonnees)){

            donnees = donneesSurDisque(classeDonnees, repertoireDonnees);

        }else{

            donnees = creerDonnees(classeDonnees);

        }

        return donnees;

    }


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

    private static boolean siDonneesSontSurDisque(Class<? extends Donnees> classeDonnees, File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        File fichierDonnees = fichierDonnees(classeDonnees, repertoireDonnees);

        return fichierDonnees.exists();
    }

    private static File fichierDonnees(Class<? extends Donnees> classeDonnees, File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        String nomFichier = nomFichierPourClasseDonnees(classeDonnees);

        String cheminFichier = repertoireDonnees.getPath() + "/" + nomFichier;

        File fichierDonnees = new File(cheminFichier);

        return fichierDonnees;

    }

    private static <D extends Donnees> D donneesSurDisque(Class<D> classeDonnees, File repertoireDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        File fichierDonnees = fichierDonnees(classeDonnees, repertoireDonnees);

        FileReader readerDonnees;

        try {

            readerDonnees = new FileReader(fichierDonnees);

        } catch (FileNotFoundException e) {

            throw new RuntimeException("Erreur de lecture, fichier: " + fichierDonnees.getPath());

        }

        D donnees = gson.fromJson(readerDonnees, classeDonnees);

        GLog.valeurs("Données lues du disque", gson.toJson(donnees));

        return donnees;

    }


    private static String nomFichierPourClasseDonnees(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        return classeDonnees.getSimpleName() + ".json";

    }

    private static boolean siDonneesSontDansEtat(Class<? extends Donnees> classeDonnees , Bundle etat){
        GLog.appel(EntrepotDeDonnees.class);

        String cleDonnees = clePourClasseDonnees(classeDonnees);

        return etat != null && etat.containsKey(cleDonnees);

    }

    public static <D extends Donnees> D donneesDansEtat(Class<D> classeDonnees, Bundle etat){
        GLog.appel(EntrepotDeDonnees.class);

        String cleDonnees = clePourClasseDonnees(classeDonnees);

        String donneesJson = etat.getString(cleDonnees);

        GLog.valeurs("Données chargées: ", classeDonnees, donneesJson);

        return gson.fromJson(donneesJson, classeDonnees);

    }

    public static <D extends Donnees> void sauvegarderDansEtat(D donnees, Bundle outState) {
        GLog.appel(EntrepotDeDonnees.class);

        String cle = clePourClasseDonnees(donnees.getClass());
        String donneesJson = gson.toJson(donnees);

        GLog.valeurs("Données sauvegardées dans l'état", cle, donneesJson);

        outState.putString(cle, gson.toJson(donnees));
    }

    private static String clePourClasseDonnees(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        return classeDonnees.getSimpleName();
    }

    private static <D extends Donnees> D donneesDansEntrepot(Class<D> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        return (D) entrepot.get(classeDonnees);
    }

    public static <D extends Donnees> void sauvegarderSurDisque(D donnees, File repertoireDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        File fichierDonnees = fichierDonnees(donnees.getClass(), repertoireDonnees);

        FileWriter writerDonnees;

        try {

            writerDonnees = new FileWriter(fichierDonnees);

        } catch (IOException e) {

            throw new RuntimeException("Impossible d'ouvrir le fichier: " + fichierDonnees.getPath());

        }

        String donneesJson = gson.toJson(donnees);

        try {

            writerDonnees.write(donneesJson);
            writerDonnees.close();

        } catch (IOException e) {

            throw new RuntimeException("Impossible d'écrire, fichier: " + fichierDonnees.getPath());

        }

        GLog.valeurs("Données sauvegardées sur le disque", donneesJson);
    }

    private static boolean siDonneesSontDansEntrepot(Class<? extends Donnees> classeDonnees){
        GLog.appel(EntrepotDeDonnees.class);

        return entrepot.containsKey(classeDonnees);
    }

    private static <D extends Donnees> void entreposerDonnees(D donnees){
        GLog.appel(EntrepotDeDonnees.class);

        entrepot.put(donnees.getClass(), donnees);
    }

    public static void effacerDonnees(Class<? extends Donnees> classeDonnees, File repertoireDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        effacerDansEntrepot(classeDonnees);
        effacerSurDisque(classeDonnees, repertoireDonnees);
    }

    private static Donnees effacerDansEntrepot(Class<? extends Donnees> classeDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        return entrepot.remove(classeDonnees);
    }

    private static <D extends Donnees> void effacerSurDisque(Class<? extends Donnees> classeDonnees, File repertoireDonnees) {
        GLog.appel(EntrepotDeDonnees.class);

        File fichierDonnees = fichierDonnees(classeDonnees, repertoireDonnees);
        fichierDonnees.delete();
    }
}
