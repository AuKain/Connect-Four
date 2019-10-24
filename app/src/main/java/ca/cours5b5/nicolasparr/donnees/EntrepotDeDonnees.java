package ca.cours5b5.nicolasparr.donnees;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.nicolasparr.global.GLog;

public class EntrepotDeDonnees {

    static Map<Class<? extends Donnees>, Donnees> donneesParId = new HashMap<>();

    public static <D extends Donnees> D obtenirDonnees(Class<D> classeDonnees) {

        if (siDonneesSontDansEntrepot(classeDonnees)) {
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
}
