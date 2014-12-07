package grammaire;

import java.util.HashSet;
import java.util.Set;

public class ChomskyGrammar {
	/*Attributs*/
	private Variable axiome ;
	private Set<Regle> regles;
	
	
	/**
	 * la grammaire est vide il faut rajouter l'axiome et l'ensemble de règles avec les 3 fonctions qui suivent.
	 */
	public ChomskyGrammar() {
		this.regles = new HashSet<Regle>();
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
		this.regles.add(new Regle(X,Y,Z));
	}
	public void addRule(Variable X, char a){
		this.regles.add(new Regle(X,a));
	}
	
	public void ajouteRegleDonnantChar(char a, Cellule c){
		for (Regle regle : this.regles) {
			if(regle.donneChar(a))
				c.addVar(regle.getVar());
		}
	}
	
	public void ajouteRegleDonnantCouple(Variable Y, Variable Z,Cellule c){
		for (Regle regle : this.regles) {
			if(regle.donneVar(Y,Z))
				c.addVar(regle.getVar());
		};
	}
	
	
	public boolean accept(String mot) {
		int longueur = mot.length();
		Cellule[][] monTableau= new Cellule[longueur][longueur];
		for(int a = 0; a < longueur; a++)
			for(int b = 0; b < longueur; b++)
				monTableau[a][b] = new Cellule();
		for(int i=1;i<=longueur;i++)
			this.ajouteRegleDonnantChar(mot.charAt(i-1), monTableau[0][i-1]);
		for(int l=2;l<=longueur;l++){ 
			for(int i=1;i<=longueur-l+1;i++){
				for(int m= 1;m<=l-1;m++){
					Set<Variable> lesY = monTableau[m-1][i-1].getVariable() ;
					Set<Variable> lesZ = monTableau[l-m-1][i+m-1].getVariable() ;
					for (Variable Y : lesY) 
						for (Variable Z : lesZ)
							this.ajouteRegleDonnantCouple(Y,Z,monTableau[l-1][i-1]) ;
				}
			}
		}
		return monTableau[longueur-1][0].getVariable().contains(this.axiome);
	}
	
}
