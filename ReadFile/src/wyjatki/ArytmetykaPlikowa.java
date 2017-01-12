package wyjatki;

import watki.WatekMnozacy;
import watki.WatekSumujacy;
import watki.Wynik;
import wyjatki.*;
import interfejsy.MnoznikInterface;
import interfejsy.SumatorInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//

public class ArytmetykaPlikowa implements SumatorInterface, MnoznikInterface {

	static String filename;
	//Przykład na stringach:
	ArrayList<String[]> list = new ArrayList<String[]>();
	//Przykład na character:
	ArrayList<char[]> list2 = new ArrayList<char[]>();

	int lengthOfLine;
	int result = 0;
	String line = null;

	/****** Sumowanie cyfr w kolumnach *****/
	public long sum(String filename, int colNumber) throws WyjatekSumowania,
			IOException {
		int lineCounter = 0;
		result = 0;
		BufferedReader br = new BufferedReader(new FileReader(filename));

		while ((line = br.readLine()) != null) {

			String[] signs = line.split("");
			list.add(signs);
			lengthOfLine = line.length(); // +1

			if (lengthOfLine < colNumber) {
				br.close();
				throw new WyjatekSumowania(null, lengthOfLine);
			} else {
				Pattern p = Pattern.compile("[0-9]");
				String str = signs[colNumber + 1]; // bo kolumny liczone od 0

				Matcher m = p.matcher(str);

				if (!m.matches()) {
					br.close();
					throw new WyjatekSumowania(line, lineCounter + 1);

				} else {
					int temp = Integer.parseInt(str);
					result = result + temp;
				}
				lineCounter++;

			}
		}
		br.close();
		return result;
	}

	/*********** Mnozenie cyfry w wierszach *************/
	public long mnoz(String filename, int lineNumber) throws WyjatekMnozenia,
			IOException {
		int lineCounter2 = 0;
		char[] rowDigits;
		
		long result = 1L;
		Pattern p = Pattern.compile("[0-9]");

		BufferedReader br = new BufferedReader(new FileReader(filename));

		while ((line = br.readLine()) != null) {

			rowDigits = line.toCharArray();
			list2.add(rowDigits);

		}
		int sign = 0;
		if (lineNumber < 0) {
			br.close();
			throw new WyjatekMnozenia(filename, lineNumber);

		}
		if (list2.size() < lineNumber) {
			br.close();
			throw new WyjatekMnozenia(filename + ", ta linia nie istnieje: "
					+ null, lineNumber);
		} else
			for (char c : list2.get(lineNumber)) {

				sign++;
				Matcher m = p.matcher("" + c);

				if ((!m.matches()))

					throw new WyjatekMnozenia(Arrays.toString(list2
							.get(lineNumber)), sign);
				br.close();
				
				result = result * +Long.valueOf(c);

				lineCounter2++;
			}
	        br.close();
		return result;
	}

	public static void main(String[] argv) throws InterruptedException {

		ArytmetykaPlikowa ob = new ArytmetykaPlikowa();
		Wynik w = new Wynik();
		Wynik w2 = new Wynik();

		WatekSumujacy ws = new WatekSumujacy("test.txt", 2, ob, w);
		WatekMnozacy ws2 = new WatekMnozacy("test.txt", 1, ob, w2);
		ws.start();
		ws.join();
		ws2.start();
		ws2.join();
		System.out.println("Wynik w¹tka sumuj¹cego: " + w.getWynik());
		System.out.println("Wynik w¹tka mnozacego: " + w2.getWynik());

		try {
			long wynikSumowania = ob.sum("test.txt", 3);
			System.out.println("WYNIK Sumowania :" + wynikSumowania);

		} catch (WyjatekSumowania e) {
			System.out.println(e + " w wierszu: " + e.getLine()
					+ ", numer wiersza: " + e.getLineNo());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Brak pliku. ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("z³apa³eœ ale zwyk³ym wyj¹tkiem a nie w³asnym");
			e.printStackTrace();
		}
		try {
			long wynikMnozenia = ob.mnoz("test.txt", 2);
			System.out.println("WYNIK Mno¿enia :" + wynikMnozenia);

		} catch (WyjatekMnozenia e) {
			System.out.println(e + " w wierszu: " + e.getLine()
					+ ", numer znaku: " + e.getLineNo());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Brak pliku. ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("z³apa³eœ ale zwyk³ym wyj¹tkiem a nie w³asnym");
			e.printStackTrace();
		}

	}

}
