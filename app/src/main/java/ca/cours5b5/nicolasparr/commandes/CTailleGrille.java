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
        modele.choisirTaille(tailleGrille);
    }

    @Override
    public boolean siExecutable() {

        return tailleGrille != modele.getTailleGrille();
    }
}