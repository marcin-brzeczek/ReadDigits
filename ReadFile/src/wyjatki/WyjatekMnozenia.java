package wyjatki;

public class WyjatekMnozenia extends Exception {
	
	
	public String errorLine;
	public int numErrorLine;
	
	public WyjatekMnozenia(String errorLine, int numErrorLine){
		this.errorLine = errorLine;
		this.numErrorLine = numErrorLine;
	}
	
	public String getLine(){
		return errorLine;
	}
	
	public int getLineNo(){
		return numErrorLine;
	}
}
