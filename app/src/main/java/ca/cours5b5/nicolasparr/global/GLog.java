package ca.cours5b5.nicolasparr.global;

import android.util.Log;
import android.view.View;

public class GLog {

    private static final int INDICE_APPEL_A_AFFICHER = 5;

    private static final String PREFIXE = "GLog";

    private static final String SEPARATEUR_NOM_CLASSE = "\\.";

    private static final int BORNE_FORMATTAGE_EN_HEX = 100000;

    public static void appel(Class classeAppelee){

        String nomClasseAppelee = classeAppelee.getSimpleName();

        afficherMethode(nomClasseAppelee);

    }

    public static void appel(Object objetAppele){

        String nomClasseAppelee = objetAppele.getClass().getSimpleName();

        afficherMethode(nomClasseAppelee);

    }

    public static void valeurs(Object... valeurs){

        // XXX: extra appel volontaire pour avoir la bonne profondeur dans la pile d'appel
        afficherValeurs(valeurs);

    }

    private static void afficherValeurs(Object... valeurs){

        String chaineValeurs = getChaineValeurs(valeurs);

        StackTraceElement appelAAfficher = getAppel();

        String nomFichier = appelAAfficher.getFileName();

        int numeroLigne = appelAAfficher.getLineNumber();

        String etiquette = PREFIXE + " (" + nomFichier  + ":" + numeroLigne + ") VALEURS";

        Log.d(etiquette, chaineValeurs);

    }

    private static StackTraceElement getAppel(){

        StackTraceElement[] pileAppels = Thread.currentThread().getStackTrace();
        StackTraceElement appelAAfficher = pileAppels[INDICE_APPEL_A_AFFICHER];

        return appelAAfficher;

    }

    private static void afficherMethode(String nomClasseAppelee){

        StackTraceElement appelAAfficher = getAppel();

        String nomMethode = getNomMethode(appelAAfficher);

        String nomFichier = appelAAfficher.getFileName();

        int numeroLigne = appelAAfficher.getLineNumber();

        String etiquette = PREFIXE + " (" + nomFichier + ":" + numeroLigne + ") APPEL";

        String chaineAppel = nomClasseAppelee + "." + nomMethode;

        Log.d(etiquette, chaineAppel);

    }

    private static String getNomMethode(StackTraceElement appelAAfficher){

        String nomMethode = appelAAfficher.getMethodName();

        return nomMethode;
    }

    private static String getChaineValeurs(Object... valeurs){
        if(valeurs.length == 0){
            return "";
        }

        String chaineValeurs = "";

        for(int i=0; i < valeurs.length; i++){

            chaineValeurs += getChaineValeur(valeurs[i]);

            if(i<(valeurs.length-1)){

                chaineValeurs += ", ";

            }
        }

        return chaineValeurs;
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

        }else if(valeur instanceof View){

            return valeur.getClass().getSimpleName() + " [" + getChaineValeur(((View) valeur).getId()) + "]";

        }else{

            return valeur.getClass().getSimpleName();

        }
    }
}
