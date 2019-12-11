package ca.cours5b5.nicolasparr.donnees;

public abstract class Donnees<D extends Donnees> {

    /*
     * TODO Attribut privé pour stoquer la version courante des données
     *  (ajouter aussi un getter)
     */

    public void notifierModificationLocale() {
        /*
         * TODO Incrémenter la version courante
         */
    }

    public void copierDonnees(D donneesRecues) {
        /*
         * TODO Copier les données
         * (p.ex. la version)
         *
         * NOTE: cette méthode doit être
         *       redéfinie dans DPartie et
         *       DParametres
         */
    }
}
