package ca.cours5b5.nicolasparr.commandes;

import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.modeles.MParametres;

public class CTailleGrille extends Commande {

    private static MParametres modele;
    private ETailleGrille tailleGrille;

    public static void initialiser(MParametres modele) {

        CTailleGrille.modele = modele;
    }

    public CTailleGrille(ETailleGrille tailleGrille) {

        this.tailleGrille = tailleGrille;
    }

    @Override
    public void executer() {
        /*
         * TODO Appeler le modèle
         */
    }

    @Override
    public boolean siExecutable() {
        /*
         * TODO Appeler le modèle
         */

        return false;
    }
}