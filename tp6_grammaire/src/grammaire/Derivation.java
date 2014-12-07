/**
 * @author Matthieu Caron
 * @author Arnaud Cojez 
 */

package grammaire;

/**
 * Interface représentant une dérivation.
 */
public interface Derivation {

	/**
	 * Retourne true si le symbole donne le caractère c.
	 * 
	 * @return true si le symbole donne le caractère c
	 */
	public boolean donneChar(char c);

	/**
	 * Retourne true si le symbole donne la variable y.
	 * 
	 * @return true si le symbole donne la variable y
	 */
	public boolean donneVar(Variable y, Variable z);
}
