package ca.cours5b5.nicolasparr.donnees.partie;

import ca.cours5b5.nicolasparr.donnees.Donnees;

public interface RetourDonnees<D extends Donnees> {

    void recevoirDonnees(D donnees);
}
