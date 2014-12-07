/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package grammaire.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import grammaire.ChomskyGrammar;
import grammaire.Variable;

import org.junit.Test;

/**
 * Classe utilisée pour tester le fonctionnement de la ChomskyGrammar
 */
public class ChomskyGrammarTest {

	@Test
	public void test() {

		/* Initialisation des variables */
		ChomskyGrammar cg = new ChomskyGrammar();
		Variable varS = new Variable("S");
		Variable varA = new Variable("A");
		Variable varB = new Variable("B");
		Variable varC = new Variable("C");

		/* Ajout de l'axiome et des règles à cg */
		cg.axiome(varS);
		cg.addRule(varS, varA, varB);
		cg.addRule(varS, varB, varC);
		cg.addRule(varA, varB, varA);
		cg.addRule(varA, 'a');
		cg.addRule(varB, varC, varC);
		cg.addRule(varB, 'b');
		cg.addRule(varC, varA, varB);
		cg.addRule(varC, 'a');

		/* Les tests à proprement parler */
		assertTrue(cg.accept("baaba"));
		assertFalse(cg.accept("a"));
		assertFalse(cg.accept(""));
		assertFalse(cg.accept("c"));
	}

}
