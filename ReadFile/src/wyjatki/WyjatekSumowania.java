package wyjatki;

public class WyjatekSumowania extends Exception{
	public String errorLine;
	public int numErrorLine;
	
	public WyjatekSumowania(String errorLine, int numErrorLine){
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
