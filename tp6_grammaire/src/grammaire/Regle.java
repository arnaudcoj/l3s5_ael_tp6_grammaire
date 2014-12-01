package grammaire;

public class Regle {
	/*Une règle c est une Variable qui renvoie un Symbole donc soit un couple de deux Variables soit un Terminal*/
	private Variable depart;
	private Derivation arrivee;
	
	
	public Regle(Variable X,Variable Y,Variable Z){
		this.depart=X;
		this.arrivee=new CoupleVariable(Y, Z);
	}
	public Regle(Variable X, char a){
		this.depart=X;
		this.arrivee=new Symbole(a);
	}
	
	/*les methodes utiles seront implémentées plus tard quand je saurais un peu mieux ce dont j'ai besoin*/
	
	
	
}
