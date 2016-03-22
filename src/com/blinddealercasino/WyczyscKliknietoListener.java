package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs tworzenia obiektu zdarzenia generowanego, gdy gracz kliknie przycisk start. Zdarzenie odpala 
 * metodê losuj¹c¹ w mainFrame.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface WyczyscKliknietoListener extends EventListener {

	public void wyczyscKliknieto(WyczyscKliknietoEvent event);
	
}
