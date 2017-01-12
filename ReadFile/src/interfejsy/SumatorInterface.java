package interfejsy;
import java.io.IOException;

import wyjatki.WyjatekSumowania;

public interface SumatorInterface {
	public long sum(String filename, int colNumber) throws WyjatekSumowania, IOException;
	
}
