package ca.cours5b5.nicolasparr.donnees;

public interface RetourChargement<D extends Donnees> {

    void chargementReussi (D donnees);

    void chargementEchoue ();
}
