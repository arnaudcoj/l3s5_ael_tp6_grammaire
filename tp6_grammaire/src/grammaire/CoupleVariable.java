package grammaire;

public class CoupleVariable extends Derivation{
	private Variable vari1;
	private Variable vari2;
	
	public CoupleVariable(Variable x1,Variable x2){
		this.vari1=x1;
		this.vari2=x2;
	}
	
	public Variable getVari1(){
		return this.vari1;
	}
	
	public Variable getVari2(){
		return this.vari2;
	}
}
