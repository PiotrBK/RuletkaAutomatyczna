package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia obstawienia powy¿ej maksimum np. na szanse proste.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class PowyzejMaksimumEvent extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5682575604665639484L;

	public PowyzejMaksimumEvent(Object source){
		super(source);
	}
}
