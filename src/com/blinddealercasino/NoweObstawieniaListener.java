package com.blinddealercasino;

import java.util.EventListener;


/** 
 * Interfejs odpowiadaj¹cy wygenerowanie zdarzenia klikniêcia przez gracza przycisku noweObstawienia
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public interface NoweObstawieniaListener extends EventListener {

	public void fireNoweObstawieniaEvent(NoweObstawieniaEvent event);
	
}
