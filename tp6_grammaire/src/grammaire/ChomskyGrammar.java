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
		regles.add(new Regle(X,Y,Z));
	}
	public void addRule(Variable X, char a){
		regles.add(new Regle(X,a));
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
		for(int i=0;i<mot.length();i++){
			/*monTableau[0][i]=new Cellule();*/
			/*si il existe une regle X qui donne mot[i] mettre X dans la cellule (1,i)*/
			this.ajouteRegleDonnantChar(mot.charAt(i), monTableau[0][i]);
		}
		for(int l=0;l<longueur;l++){ /* là c est le moment de vomir en lisant l'algo*/
			for(int i=0;i<longueur-l+1;i++){
				for(int m= 0;m<l-1;m++){
					/*Si il existe un X qui donne YZ avec Y dans la cellule(m,i) et Z dans la cellule (l-m,i+m)
					 * alors ajouter X à la cellule(l,i)*/
					Set<Variable> lesY = monTableau[m][i].getVariable() ;
					Set<Variable> lesZ = monTableau[l-m][i+m].getVariable() ;
					for (Variable Y : lesY) {
						for (Variable Z : lesZ) {
							this.ajouteRegleDonnantCouple(Y,Z,monTableau[l][i]) ;
						}
						
					}
				}
			}
		}
		return monTableau[longueur-1][1].getVariable().contains(this.axiome);
	}
}
