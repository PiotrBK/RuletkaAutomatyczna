/**
 * 
 */
package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj¹cy za generowanie obiektu zdarzenia kliniêcia przycisku rebet2x.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public interface Rebet2xListener extends EventListener {
	
	public void fireRebet2xEvent(Rebet2xEvent event);
	
	
}
