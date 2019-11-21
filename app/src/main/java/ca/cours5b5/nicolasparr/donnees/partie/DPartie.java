package ca.cours5b5.nicolasparr.donnees.partie;


import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.enumerations.ETailleGrille;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;

public abstract class DPartie extends Donnees {

    private ETailleGrille tailleGrille = GConstantes.TAILLE_GRILLE_PAR_DEFAUT;
    private DGrille dGrille;
    private ECouleur prochaineCouleur = GConstantes.COULEUR_QUI_COMMENCE;

    public DPartie(){
        GLog.appel(this);

        dGrille = new DGrille(tailleGrille.getLargeur());
    }

    public DGrille getGrille() {
        GLog.appel(this);

        return dGrille;
    }

    public void setGrille(DGrille dGrille) {
        GLog.appel(this);

        this.dGrille = dGrille;
    }

    public ECouleur getProchaineCouleur() {
        GLog.appel(this);

        return prochaineCouleur;
    }

    public void setProchaineCouleur(ECouleur prochaineCouleur) {
        GLog.appel(this);

        this.prochaineCouleur = prochaineCouleur;
    }

    public ETailleGrille getTailleGrille() {
        GLog.appel(this);

        return tailleGrille;
    }

    public void setTailleGrille(ETailleGrille tailleGrille) {
        GLog.appel(this);

        this.tailleGrille = tailleGrille;
        dGrille = new DGrille(tailleGrille.getLargeur());
    }

    public boolean siColonnePleine(int indiceColonne){
        GLog.appel(this);

        DColonne colonne = dGrille.getColonnes().get(indiceColonne);

        int nombreJetons = colonne.getCases().size();

        int nombreJetonsMax = tailleGrille.getHauteur();

        return nombreJetons >= nombreJetonsMax;
    }
}
