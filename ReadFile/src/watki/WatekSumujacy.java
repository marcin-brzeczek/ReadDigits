package watki;

import java.io.IOException;

import wyjatki.ArytmetykaPlikowa;
import wyjatki.WyjatekSumowania;

public class WatekSumujacy extends Thread {
	public String string;
	public int kolumna;
	public ArytmetykaPlikowa localArytmetykaPlikowa2;
	public Wynik localWynik2;

	public WatekSumujacy(String string, int kolumna,
			ArytmetykaPlikowa localArytmetykaPlikowa2, Wynik localWynik2) {
		// TODO Auto-generated const
		this.string = string;
		this.kolumna = kolumna;
		this.localArytmetykaPlikowa2 = localArytmetykaPlikowa2;
		this.localWynik2 = localWynik2;
	}

	@Override
	public synchronized void run() {
		
		long wynik=0;
		try {
	
				wynik=0;
				localWynik2.setWynik(wynik);
			wynik = localArytmetykaPlikowa2.sum(string, kolumna);
			localWynik2.setWynik(wynik);
			Thread.yield();
		
		
		} catch (WyjatekSumowania e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}
}
