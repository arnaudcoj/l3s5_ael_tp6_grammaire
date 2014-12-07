/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package grammaire;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant une cellule contenant un ensemble de variables.
 */
public class Cellule {

	/* Attributs */
	private Set<Variable> lesVariables;

	/* Méthodes */

	/**
	 * Constructeur de la classe Cellule.
	 * 
	 * La cellule est vide, il faudra utiliser la méthode addVar pour la
	 * remplir.
	 */
	public Cellule() {
		this.lesVariables = new HashSet<Variable>();
	}

	/**
	 * Ajoute la variable var à la Cellule.
	 * 
	 * @param var
	 *            la variable à ajouter
	 */
	public void addVar(Variable var) {
		this.lesVariables.add(var);
	}

	/**
	 * Retourne l'ensemble des variables contenues dans la Cellule.
	 * 
	 * @return l'ensemble des variables contenues dans la Cellule
	 */
	public Set<Variable> getVariable() {
		return this.lesVariables;
	}

}
