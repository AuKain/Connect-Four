package ca.cours5b5.nicolasparr.donnees.partie;

import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.global.GLog;

public class DCase {

    private ECouleur couleur;

    public ECouleur getCouleur() {
        GLog.appel(this);

        return couleur;
    }

    public void setCouleur(ECouleur couleur) {
        GLog.appel(this);

        this.couleur = couleur;
    }
}
