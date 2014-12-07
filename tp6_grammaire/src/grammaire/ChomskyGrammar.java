/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package grammaire;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe définissant la grammaire de Chomsky.
 */
public class ChomskyGrammar {

	/* Attributs */
	private Variable axiome;
	private Set<Regle> regles;

	/* Méthodes */

	/**
	 * Constructeur de la classe ChomskyGrammar.
	 * 
	 * Note : la grammaire est vide il faut rajouter l'axiome et l'ensemble de
	 * règles avec les 3 fonctions qui suivent.
	 */
	public ChomskyGrammar() {
		this.regles = new HashSet<Regle>();
	}

	/**
	 * Ajoute ou remplace l'axiome s.
	 * 
	 * @param s
	 *            la variable destinée à être l'axiome de l'objet
	 *            ChomskyGrammar
	 */
	public void axiome(Variable s) {
		this.axiome = s;
	}

	/**
	 * Ajoute une règle de la forme x->yz à l'ensemble des règles de l'objet
	 * ChomskyGrammar.
	 * 
	 * @param x
	 *            Membre gauche
	 * @param y
	 *            1ere variable du membre droit
	 * @param z
	 *            2e variable du membre gauche
	 */
	public void addRule(Variable x, Variable y, Variable z) {
		this.regles.add(new Regle(x, y, z));
	}

	/**
	 * Ajoute une règle à l'objet ChomskyGrammar.
	 * 
	 * @param x
	 *            Membre gauche
	 * @param car
	 *            Membre terminal droit
	 */
	public void addRule(Variable x, char car) {
		this.regles.add(new Regle(x, car));
	}

	/**
	 * Ajoute dans la cellule cell une des règle de this donnant le caractère
	 * car.
	 * 
	 * @param car
	 *            le caractère dont on veut ajouter la règle
	 * @param cell
	 *            la cellule
	 */
	public void ajouteRegleDonnantChar(char car, Cellule cell) {
		for (Regle regle : this.regles) {
			if (regle.donneChar(car))
				cell.addVar(regle.getVar());
		}
	}

	/**
	 * Ajoute une des règles de this donnant les variables y et z à la cellule
	 * cell.
	 * 
	 * @param y
	 *            1ère variable du couple dont on veut ajouter la règle
	 * @param z
	 *            2ème variable du couple dont on veut ajouter la règle
	 * @param cell
	 *            la cellule
	 */
	public void ajouteRegleDonnantCouple(Variable y, Variable z, Cellule cell) {
		for (Regle regle : this.regles) {
			if (regle.donneVar(y, z))
				cell.addVar(regle.getVar());
		}
		;
	}

	/**
	 * Retourne true si mot est reconnu par la grammaire.
	 * 
	 * @param mot
	 *            le mot pour lequel on veut vérifier l'appartenance à la
	 *            grammaire
	 * @return true si le mot est reconnu par la grammaire
	 */
	public boolean accept(String mot) {
		int longueur = mot.length();
		if (longueur < 1)
			return false;
		Cellule[][] monTableau = new Cellule[longueur][longueur];
		/* Initialisation des cellules du tableau */
		for (int a = 0; a < longueur; a++)
			for (int b = 0; b < longueur; b++)
				monTableau[a][b] = new Cellule();
		/*
		 * Initialisation de la première ligne du tableau avec les règles
		 * donnant les lettres du mot
		 */
		for (int i = 1; i <= longueur; i++)
			this.ajouteRegleDonnantChar(mot.charAt(i - 1), monTableau[0][i - 1]);

		for (int l = 2; l <= longueur; l++) {
			for (int i = 1; i <= longueur - l + 1; i++) {
				for (int m = 1; m <= l - 1; m++) {
					Set<Variable> lesY = monTableau[m - 1][i - 1].getVariable();
					Set<Variable> lesZ = monTableau[l - m - 1][i + m - 1]
							.getVariable();
					for (Variable y : lesY)
						for (Variable z : lesZ)
							this.ajouteRegleDonnantCouple(y, z,
									monTableau[l - 1][i - 1]);
				}
			}
		}
		return monTableau[longueur - 1][0].getVariable().contains(this.axiome);
	}

}
