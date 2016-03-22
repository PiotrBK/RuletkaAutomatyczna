package com.blinddealercasino;

import java.util.EventObject;


/** 
 * 
 * Klasa odpowiadaj¹ca za obiekt zdarzenia klikniêcia nowych obstawieñ przez gracza.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class NoweObstawieniaEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -29118219376271647L;

	public NoweObstawieniaEvent(Object source){
		super(source);
	}
	
}
