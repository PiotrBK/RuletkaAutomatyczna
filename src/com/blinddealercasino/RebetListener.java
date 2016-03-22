package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj¹cy za wygenerowanie obiektu zdarzenia klikniêcia przycisku powtórnego obstawienia.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface RebetListener extends EventListener {

	public void fireRebetEvent(RebetEvent event);
	
}
