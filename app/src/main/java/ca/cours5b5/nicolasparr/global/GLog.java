package ca.cours5b5.nicolasparr.global;

import android.util.Log;

public class GLog {

    private static final int INDICE_APPEL_A_AFFICHER = 5;

    private static final String PREFIXE = "GLog";



    private static final String SEPARATEUR_NOM_CLASSE = "\\.";

    private static final int BORNE_FORMATTAGE_EN_HEX = 100000;

    public static void appel(Class classeAppelante){

        String nomClasseAppelante = classeAppelante.getSimpleName();

        afficherMethode(nomClasseAppelante);

    }

    public static void appel(Object objetAppelant){

        String nomClasseAppelante = objetAppelant.getClass().getSimpleName();

        afficherMethode(nomClasseAppelante);

    }

    public static void valeurs(Object... valeurs){

        // XXX: extra appel volontaire pour avoir la bonne profondeur dans la pile d'appel
        afficherValeurs(valeurs);

    }

    private static void afficherValeurs(Object... valeurs){

        String chaineValeurs = getChaineValeursAdditionnelles(valeurs);

        StackTraceElement appelAAfficher = getAppel();

        String nomFichier = appelAAfficher.getFileName();

        int numeroLigne = appelAAfficher.getLineNumber();

        String nomMethode = getNomMethode(appelAAfficher);

        String nomClasseContenantCode = getNomClasseSimple(appelAAfficher);

        String etiquette = PREFIXE + " (" + nomFichier  + ":" + numeroLigne + ") VALEURS";

        Log.d(etiquette, chaineValeurs);

    }

    private static StackTraceElement getAppel(){

        StackTraceElement[] pileAppels = Thread.currentThread().getStackTrace();
        StackTraceElement appelAAfficher = pileAppels[INDICE_APPEL_A_AFFICHER];

        return appelAAfficher;

    }

    private static void afficherMethode(String nomClasseAppelante){

        StackTraceElement appelAAfficher = getAppel();

        String nomMethode = getNomMethode(appelAAfficher);

        String nomClasseContenantCode = getNomClasseSimple(appelAAfficher);

        String nomFichier = appelAAfficher.getFileName();

        int numeroLigne = appelAAfficher.getLineNumber();

        String etiquette = PREFIXE + " (" + nomFichier + ":" + numeroLigne + ") APPEL";

        String chaineAppel = nomClasseAppelante + "." + nomMethode;

        Log.d(etiquette, chaineAppel);

    }

    private static String getNomMethode(StackTraceElement appelAAfficher){

        String nomMethode = appelAAfficher.getMethodName();

        return nomMethode;
    }

        private static String getNomClasseSimple(StackTraceElement appelAAfficher) {

        String nomClasseComplet = appelAAfficher.getClassName();

        String nomClasseSimple = getNomClasseSimple(nomClasseComplet);

        return nomClasseSimple;
    }

    private static String getNomClasseSimple(String nomClasseComplet){

        String[] segmentsDuNom = nomClasseComplet.split(SEPARATEUR_NOM_CLASSE);

        String nomClasseSimple = segmentsDuNom[segmentsDuNom.length - 1];

        return nomClasseSimple;

    }


    private static String getChaineAppel(String nomClasseSimple, String nomMethode, Object... valeursAdditionnelles){

        String appel = nomClasseSimple;

        appel += ".";

        appel += nomMethode;

        appel += "()";

        appel += getChaineValeursAdditionnelles(valeursAdditionnelles);

        return appel;
    }

    private static String getChaineValeursAdditionnelles(Object... valeursAdditionnelles){
        if(valeursAdditionnelles.length == 0){
            return "";
        }

        String chaineValeursAdditionnelles = "";

        for(int i=0; i < valeursAdditionnelles.length; i++){

            chaineValeursAdditionnelles += getChaineValeur(valeursAdditionnelles[i]);

            if(i<(valeursAdditionnelles.length-1)){

                chaineValeursAdditionnelles += ", ";

            }
        }

        return chaineValeursAdditionnelles;
    }

    private static String getChaineValeur(Object valeur){
        if(valeur instanceof Integer){

            if((Integer) valeur >= BORNE_FORMATTAGE_EN_HEX){

                return String.format("0x%08X", valeur).toLowerCase();

            }else{

                return valeur.toString();
            }
        }

        else if(valeur instanceof Long
                || valeur instanceof Boolean
                || valeur instanceof Float
                || valeur instanceof Double
                || valeur instanceof String){

            return valeur.toString();

        }else if(valeur == null){

            return "null";

        }else{

            return valeur.getClass().getSimpleName();

        }
    }
}
