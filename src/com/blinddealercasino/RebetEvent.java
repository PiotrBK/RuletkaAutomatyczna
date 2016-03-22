package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia klikniêcia przycisku powtórnego obstawienia.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class RebetEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5166402444904451942L;

	public RebetEvent(Object source){
		super(source);
	}
	
}
