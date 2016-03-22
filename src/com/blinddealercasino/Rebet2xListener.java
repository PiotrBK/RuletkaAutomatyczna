/**
 * 
 */
package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj�cy za generowanie obiektu zdarzenia klini�cia przycisku rebet2x.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public interface Rebet2xListener extends EventListener {
	
	public void fireRebet2xEvent(Rebet2xEvent event);
	
	
}
