package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj�cy za tworzenie obiektu zdarzenia generowanego, gdy gracz kliknie przycisk start. Zdarzenie odpala 
 * metod� losuj�c� w mainFrame.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface StartListener extends EventListener {

	public void startKliknieto(StartKliknietoEvent event);
	
}
