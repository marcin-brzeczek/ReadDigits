package watki;

public class Wynik{
	
	private volatile long wynik=0;
	
	public long getWynik(){
		return wynik;
	}
	
	public void setWynik(long wynik){
		this.wynik = wynik;
	}
	
}

