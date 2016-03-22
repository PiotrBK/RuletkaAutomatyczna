package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj�cy za wygenerowanie obiektu zdarzenia klikni�cia przycisku powt�rnego obstawienia.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface RebetListener extends EventListener {

	public void fireRebetEvent(RebetEvent event);
	
}
