package ca.cours5b5.nicolasparr.commandes;

import ca.cours5b5.nicolasparr.modeles.MParametres;

public class CContinuerPartie extends Commande {

    private static MParametres modele;
    private boolean continuerPartie;

    public static void initialiser(MParametres modele) {

        CContinuerPartie.modele = modele;
    }

    public CContinuerPartie (boolean continuerPartie) {
        this.continuerPartie = continuerPartie;
    }

    @Override
    public void executer() {
        /*
         * TODO Appeler le modèle
         */
    }
}
