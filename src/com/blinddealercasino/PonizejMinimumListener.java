package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadaj�cy za generowanie obiektu zdarzenia obstawienia poni�ej minimum np. na szanse proste.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public interface PonizejMinimumListener extends EventListener {

	public void firePonizejMinimumEvent(PonizejMinimumEvent event);
	
}