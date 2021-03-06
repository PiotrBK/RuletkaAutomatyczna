package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadający za generowanie obiektu zdarzenia obstawienia poniżej minimum np. na szanse proste.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyński-Kaczmarek
 * 
 */


public interface PowyzejMaksimumListener extends EventListener {

	public void firePowyzejMaksimumEvent(PowyzejMaksimumEvent event);
	
}
