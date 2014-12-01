package grammaire;

public class Symbole extends Derivation{
	/*Oui je sais pas si c'est possible de faire étendre la class char*/
	private char symbole;
	
	public Symbole(char a){
		this.symbole=a;
	}
	
	public char getSymbole(){
		return this.symbole;
	}
	
}
