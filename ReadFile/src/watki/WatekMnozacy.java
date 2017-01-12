package watki;

import java.io.IOException;

import wyjatki.ArytmetykaPlikowa;
import wyjatki.WyjatekMnozenia;
import wyjatki.WyjatekSumowania;

public class WatekMnozacy extends Thread {  
	String string;
	int wiersz;
	ArytmetykaPlikowa localArytmetykaPlikowa1;
	Wynik localWynik1;
	
	
	public WatekMnozacy(String string, int wiersz,
			ArytmetykaPlikowa localArytmetykaPlikowa1, Wynik localWynik1) {
		// TODO Auto-generated constructor stub
		this.localArytmetykaPlikowa1 =localArytmetykaPlikowa1;
		this.localWynik1 = localWynik1;
		this.wiersz =wiersz;
		this.string =string;
		
	}

	@Override
	public synchronized void run() {

		long wynik = 0;
		try {

			wynik = 0;
			localWynik1.setWynik(wynik);
			wynik = localArytmetykaPlikowa1.mnoz(string, wiersz);
			localWynik1.setWynik(wynik);
			Thread.yield();

		} catch (WyjatekMnozenia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
