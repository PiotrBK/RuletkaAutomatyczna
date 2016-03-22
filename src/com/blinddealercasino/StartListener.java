package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj¹cy za tworzenie obiektu zdarzenia generowanego, gdy gracz kliknie przycisk start. Zdarzenie odpala 
 * metodê losuj¹c¹ w mainFrame.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface StartListener extends EventListener {

	public void startKliknieto(StartKliknietoEvent event);
	
}
