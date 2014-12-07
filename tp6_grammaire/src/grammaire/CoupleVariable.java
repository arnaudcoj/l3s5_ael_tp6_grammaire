/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package grammaire;

/**
 * Classe représentant une Dérivation sous forme de couple de variables.
 */
public class CoupleVariable implements Derivation {

	/* Attributs */
	private Variable vari1;
	private Variable vari2;

	/* Méthodes */
	
	/**
	 * Constructeur de la classe CoupleVariable.
	 * @param x1 la 1ère variable
	 * @param x2 la 2ème variable
	 */
	public CoupleVariable(Variable x1, Variable x2) {
		this.vari1 = x1;
		this.vari2 = x2;
	}

	/**
	 * Retourne la 1ère variable.
	 * @return la 1ère variable
	 */
	public Variable getVari1() {
		return this.vari1;
	}

	/**
	 * Retourne la 2ème variable.
	 * @return la 2ème variable
	 */
	public Variable getVari2() {
		return this.vari2;
	}

	/**
	 * Retourne true si le symbole donne le caractère c.
	 * @return true si le symbole donne le caractère c
	 * 
	 * Note : Retournera toujours false pour la classe CoupleVariable.
	 */
	public boolean donneChar(char c) {
		return false;
	}

	/**
	 * Retourne true si le symbole donne la variable y.
	 * @return true si le symbole donne la variable y
	 */
	public boolean donneVar(Variable y, Variable z) {
		return this.vari1 == y && this.vari2 == z;
	}
}
