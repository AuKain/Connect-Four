package ca.cours5b5.nicolasparr.commandes;

import ca.cours5b5.nicolasparr.modeles.MPartie;

public class CCoupIci extends Commande {

    private static MPartie modele;

    private int noColonne;

    public static void initialiser(MPartie modele) {

        CCoupIci.modele = modele;
    }

    public CCoupIci(int noColonne) {
        this.noColonne = noColonne;
    }

    @Override
    public void executer() {
        modele.jouerCoupIci(noColonne);
    }

    @Override
    public boolean siExecutable() {

        return modele.siPossibleJouerCoup(noColonne);
    }
}
