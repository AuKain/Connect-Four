package ca.cours5b5.nicolasparr.donnees.partie;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.nicolasparr.enumerations.ECouleur;
import ca.cours5b5.nicolasparr.global.GLog;

public class DGrille {

    private List<DColonne> colonnes = new ArrayList<>();

    public DGrille(){ }

    public DGrille(int largeur){
        GLog.appel(this);

        colonnes = new ArrayList<>();
        for(int i = 0; i < largeur; i++){
            colonnes.add(new DColonne());
        }
    }


    public List<DColonne> getColonnes() {
        GLog.appel(this);

        return colonnes;
    }

    public void setColonnes(List<DColonne> colonnes) {
        GLog.appel(this);

        this.colonnes = colonnes;
    }

    public void ajouterJeton(int indiceColonne, ECouleur couleur) {
        GLog.appel(this);

        colonnes.get(indiceColonne).ajouterJeton(couleur);
    }

}
