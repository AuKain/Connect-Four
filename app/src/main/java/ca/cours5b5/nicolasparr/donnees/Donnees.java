package ca.cours5b5.nicolasparr.donnees;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Donnees<D extends Donnees> {

    private int versionCourante;

    public void notifierModificationLocale() {
        GLog.appel(this);

        this.versionCourante++;
    }

    public void copierDonnees(D donneesRecues) {
        GLog.appel(this);

        this.versionCourante = donneesRecues.getVersionCourante();
    }

    public int getVersionCourante() {
        return versionCourante;
    }
}
