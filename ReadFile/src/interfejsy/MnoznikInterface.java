package interfejsy;

import java.io.IOException;

import wyjatki.WyjatekMnozenia;


public interface MnoznikInterface {
	public long mnoz(String filename, int lineNumber) throws WyjatekMnozenia, IOException;
}
