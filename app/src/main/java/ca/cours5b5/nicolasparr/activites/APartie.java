package ca.cours5b5.nicolasparr.activites;

import ca.cours5b5.nicolasparr.donnees.partie.DPartie;
import ca.cours5b5.nicolasparr.modeles.MPartie;
import ca.cours5b5.nicolasparr.vues.pages.PPartie;

public abstract class APartie<D extends DPartie, M extends MPartie, P extends PPartie> extends ActiviteAvecModeles<D,M,P> { }
