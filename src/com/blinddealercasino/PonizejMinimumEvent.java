package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia obstawienia poni¿ej minimum np. na szanse proste.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class PonizejMinimumEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 517363441702366082L;

	public PonizejMinimumEvent(Object source){
		super(source);
		
	}
	
}
