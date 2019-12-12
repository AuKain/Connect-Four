package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Observateur<D extends Donnees> {

    private int versionCourante;

    public void notifierNouvellesDonnees(D donnees) {
        GLog.appel(this);

        this.versionCourante = donnees.getVersionCourante();

        nouveau(donnees);
    }

    public void notifierModifierDonnees(D donnees) {
        GLog.appel(this);

      //  if (donnees.getVersionCourante() > this.versionCourante) {

         //   this.versionCourante = donnees.getVersionCourante();

            donneesDuServeur(donnees);
       // }
    }

    protected abstract void nouveau(D donnees);
    protected abstract void donneesDuServeur(D donnees);
}
