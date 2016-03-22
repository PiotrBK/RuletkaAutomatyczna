package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs tworzenia obiektu zdarzenia generowanego, gdy gracz kliknie przycisk start. Zdarzenie odpala 
 * metod� losuj�c� w mainFrame.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface WyczyscKliknietoListener extends EventListener {

	public void wyczyscKliknieto(WyczyscKliknietoEvent event);
	
}
