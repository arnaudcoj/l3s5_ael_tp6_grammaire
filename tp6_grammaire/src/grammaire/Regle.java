/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package grammaire;

/**
 * Classe définissant une règle de grammaire, c'est à dire une Variable qui
 * renvoie un Symbole donc soit un couple de deux Variables soit un Terminal.
 */
public class Regle {

	/* Attributs */
	private Variable depart;
	private Derivation arrivee;

	/* Méthodes */

	/**
	 * Constructeur de la classe Regle (règle de type X->YZ).
	 * 
	 * @param x
	 *            membre gauche de la règle
	 * @param y
	 *            1er élément du membre droit de la règle
	 * @param z
	 *            2ème élément du membre droit de la règle
	 */
	public Regle(Variable x, Variable y, Variable z) {
		this.depart = x;
		this.arrivee = new CoupleVariable(y, z);
	}

	/**
	 * Constructeur de la classe Regle (règle de type X->a).
	 * 
	 * @param x
	 *            membre gauche de la règle
	 * @param a
	 *            membre droit terminal de la règle
	 */
	public Regle(Variable x, char a) {
		this.depart = x;
		this.arrivee = new Symbole(a);
	}

	/**
	 * Retourne le membre gauche.
	 * 
	 * @return le membre gauche
	 */
	public Variable getVar() {
		return this.depart;
	}

	/**
	 * Retourne true si la règle donne le char a.
	 * 
	 * @param a
	 *            le caractère dont on veut savoir l'appartenance à la règle
	 * @return true si la règle donne le char a
	 */
	public boolean donneChar(char a) {
		return this.arrivee.donneChar(a);
	}

	/**
	 * Retourne true si la règle donne les Variables y & z (l'ordre est
	 * important).
	 * 
	 * @param y
	 *            le 1er élément du membre droit
	 * @param z
	 *            le 2ème élément du membre droit
	 * @return true si la règle donne les Variables y & z
	 */
	public boolean donneVar(Variable y, Variable z) {
		return this.arrivee.donneVar(y, z);
	}
}
