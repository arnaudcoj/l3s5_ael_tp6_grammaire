package grammaire;

public abstract class Derivation {
	public abstract boolean donneChar(char c) ;

	public abstract boolean donneVar(Variable y, Variable z);
}
