package com.blinddealercasino;

import java.util.EventListener;


/** 
 * Interfejs odpowiadaj�cy wygenerowanie zdarzenia klikni�cia przez gracza przycisku noweObstawienia
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public interface NoweObstawieniaListener extends EventListener {

	public void fireNoweObstawieniaEvent(NoweObstawieniaEvent event);
	
}
