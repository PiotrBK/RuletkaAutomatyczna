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

public interface PonizejMinimumListener extends EventListener {

	public void firePonizejMinimumEvent(PonizejMinimumEvent event);
	
}
