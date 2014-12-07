/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package grammaire;

/**
 * Classe représentant une dérivation.
 */
public class Symbole implements Derivation {

	/* Attributs */
	private char symbole;

	/* Méthodes */

	/**
	 * Constructeur de la classe symbole.
	 * 
	 * @param car
	 *            le symbole sous forme de caractère
	 */
	public Symbole(char car) {
		this.symbole = car;
	}

	/**
	 * Retourne le caractère représentant le symbole.
	 * 
	 * @return le caractère représentant le symbole
	 */
	public char getSymbole() {
		return this.symbole;
	}

	/**
	 * Retourne true si le symbole donne le caractère c.
	 * 
	 * @return true si le symbole donne le caractère c
	 */
	public boolean donneChar(char c) {
		return this.symbole == c;
	}

	/**
	 * Retourne true si le symbole donne la variable y.
	 * 
	 * @return true si le symbole donne la variable y
	 * 
	 *         Note : Retournera toujours false pour la classe Symbole.
	 */
	public boolean donneVar(Variable y, Variable z) {
		return false;
	}
}
