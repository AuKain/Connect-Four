package ca.cours5b5.nicolasparr.donnees.partie;

import android.graphics.Color;

import ca.cours5b5.nicolasparr.donnees.Donnees;
import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.global.GLog;

public class DCase extends Donnees {

    private ECouleur couleur;

    public DCase(){ }

    public ECouleur getCouleur() {
        GLog.valeurs(this.couleur);
        return this.couleur;
    }
    public void setCouleur(ECouleur couleur) {
        this.couleur = couleur;
        GLog.valeurs(couleur);
    }
}