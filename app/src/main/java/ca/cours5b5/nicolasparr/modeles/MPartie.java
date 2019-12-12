package ca.cours5b5.nicolasparr.modeles;


import ca.cours5b5.nicolasparr.R;
import ca.cours5b5.nicolasparr.commandes.CCoupIci;
import ca.cours5b5.nicolasparr.commandes.CMessagePuisCommande;
import ca.cours5b5.nicolasparr.commandes.CQuitterActivite;
import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.global.GConstantes;
import ca.cours5b5.nicolasparr.global.GLog;
import ca.cours5b5.nicolasparr.vues.pages.PPartie;
import ca.cours5b5.nicolasparr.vues.pages.PPartieLocale;

public abstract class MPartie extends Modele<DPartie, PPartie> {


    public MPartie(DPartie donnees, PPartieLocale page) {
        super(donnees, page);
    }

    public void jouerCoupIci(int indiceColonne){
        GLog.appel(this);

        effectuerCoup(indiceColonne);

        this.page.rafraichirAffichage(this.donnees);

        testerSiPartieGagnee(); // Après chaque coup, tester si la partie est gagnée
    }

    public boolean siPossibleJouerCoup(int indiceColonne) {
        return !siColonnePleine(indiceColonne);
    }

    protected void effectuerCoup(int indiceColonne){
        GLog.appel(this);

        ajouterJeton(indiceColonne);
        prochainJoueur();

        notifierModificationLocale();
    }

    protected void ajouterJeton(int indiceColonne){
        GLog.appel(this);

        if(!siColonnePleine(indiceColonne)){
            ECouleur prochaineCouleur = donnees.getProchaineCouleur();
            donnees.getGrille().ajouterJeton(indiceColonne, prochaineCouleur);
        }

    }

    protected void prochainJoueur(){
        GLog.appel(this);

        prochaineCouleur();
    }

    private boolean siColonnePleine(int indiceColonne){
        GLog.appel(this);

        return donnees.siColonnePleine(indiceColonne);
    }

    private void prochaineCouleur() {
        GLog.appel(this);

        if (donnees.getProchaineCouleur() == ECouleur.ROUGE) {

            donnees.setProchaineCouleur(ECouleur.BLEU);
        } else {

            donnees.setProchaineCouleur(ECouleur.ROUGE);
        }
    }

    private void reagirPartieGagnee() {
        GLog.appel(this);

        CMessagePuisCommande.initialiser(this.page);
        new CMessagePuisCommande(getIdMessageAuGagnant(), new CQuitterActivite()).executer();

    }

    private int getIdMessageAuGagnant() {
        GLog.appel(this);

        return donnees.getProchaineCouleur() == ECouleur.BLEU ? R.string.gagne_rouge : R.string.gagne_bleu;
    }

    private boolean siPartieGagnee() {
        GLog.appel(this);

        return Math.random() < 0.2;
    }

    private void testerSiPartieGagnee() {
        GLog.appel(this);

        if (siPartieGagnee()) {
            reagirPartieGagnee();
        }
    }

    @Override
    protected void initialiserCommandes() {
        GLog.appel(this);

        CCoupIci.initialiser(this);
    }
}
