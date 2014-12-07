package grammaire;

import java.util.HashSet;
import java.util.Set;

public class Cellule {
	
	private Set<Variable> lesVariables ;

	
	public Cellule(){
		this.lesVariables=new HashSet<Variable>();
	}
	public void addVar(Variable var) {
		this.lesVariables.add(var);
		
	}
	public Set<Variable> getVariable() {
		return this.lesVariables;
	}

}
