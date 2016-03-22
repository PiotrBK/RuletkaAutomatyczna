package com.blinddealercasino;

import java.util.EventObject;

/** 
 *  Klasa obiektu zdarzenia klikniêcia przez gracza przycisku rebet2x (ponownego, ale podwojonego
 *  obstawienia takiego samego zak³adu).
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Rebet2xEvent extends EventObject {

	private static final long serialVersionUID = 7916765909271585607L;

	public Rebet2xEvent(Object source) {
		super(source);
		
	}

}
