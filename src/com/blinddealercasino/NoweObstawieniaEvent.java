package com.blinddealercasino;

import java.util.EventObject;


/** 
 * 
 * Klasa odpowiadaj�ca za obiekt zdarzenia klikni�cia nowych obstawie� przez gracza.
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
