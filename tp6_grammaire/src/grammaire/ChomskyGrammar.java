package grammaire;

public class ChomskyGrammar {
	/*Attributs*/
	private Variable axiome ;
	private Set<Regle> regles;
	
	public ChomskyGrammar() {
		//todo
	}
	
	
	/**
	 * Ajouteou remplace l'axiome S
	 * @param S la variable destinée à être l'axiome de l'objet ChomskyGrammar
	 */
	public void axiome(Variable S) {
		this.axiome=S;
	}
	
	/**
	 * Ajoute une regle à l'ensemble des regles de l'objet ChomskyGrammar avec la forme X->YZ
	 * @param X
	 * @param Y
	 * @param Z
	 */
	public void addRule(Variable X,Variable Y,Variable Z){
		regles.add(new Regle(X,Y,Z));
	}
	public void addRule(Variable X, char a){
		regles.add(new Regle(X,a));
	}
	
	public Cellule existeRegleDonnant(char a){
		return new Cellule();
	}
	
	
	public boolean accept(String mot) {
		return true;
	}
}
