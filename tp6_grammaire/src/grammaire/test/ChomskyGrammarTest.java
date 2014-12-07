package grammaire.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import grammaire.ChomskyGrammar;
import grammaire.Variable;

import org.junit.Test;

public class ChomskyGrammarTest {

	@Test
	public void test() {		
	
	ChomskyGrammar cg = new ChomskyGrammar();
	Variable varS = new Variable("S");
	Variable varA = new Variable("A");
	Variable varB = new Variable("B");
	Variable varC = new Variable("C");
	cg.axiome(varS);
	cg.addRule(varS, varA, varB);
	cg.addRule(varS, varB, varC);
	cg.addRule(varA, varB, varA);
	cg.addRule(varA, 'a');
	cg.addRule(varB, varC, varC);
	cg.addRule(varB, 'b');
	cg.addRule(varC, varA, varB);
	cg.addRule(varC, 'a');
	assertTrue(cg.accept("baaba"));
	}

}
