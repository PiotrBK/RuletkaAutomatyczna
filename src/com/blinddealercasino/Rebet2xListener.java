/**
 * 
 */
package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadający za generowanie obiektu zdarzenia klinięcia przycisku rebet2x.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyński-Kaczmarek
 * 
 */

public interface Rebet2xListener extends EventListener {
	
	public void fireRebet2xEvent(Rebet2xEvent event);
	
	
}
