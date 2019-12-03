package ca.cours5b5.nicolasparr.donnees;

public interface RetourDonnees<D extends Donnees> {

    void recevoirDonnees(D donnees);
}
