package ca.cours5b5.nicolasparr.donnees.partie;

import ca.cours5b5.nicolasparr.donnees.Donnees;

public interface RetourChargement<D extends Donnees> {

    void chargementReussi (D donnees);

    void chargementEchoue ();
}
