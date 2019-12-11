package ca.cours5b5.nicolasparr.donnees;

public abstract class Observateur<D extends Donnees> {

    /*
     * TODO Attribut privé pour stoquer la version courante
     * de l'observation des données
     */

    public void notifierNouvellesDonnees(D donnees) {
        /*
         * TODO Stoquer la version courante
         * Appeler nouveau
         */
    }

    public void notifierModifierDonnees(D donnees) {
        /*
         * TODO Si on reçoit une version plus récente:
         *     - stoquer la nouvelle version courante
         *     - appeler donneesDuServeur
         */
    }

    protected abstract void nouveau(D donnees);
    protected abstract void donneesDuServeur(D donnees);
}
