package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia klikni�cia przycisku powt�rnego obstawienia.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
