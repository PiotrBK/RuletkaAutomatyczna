package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz kliknie przycisk wyczy��.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public class WyczyscKliknietoEvent extends EventObject {

	
	private static final long serialVersionUID = -3211773636747322091L;

	public WyczyscKliknietoEvent(Object source){
		super(source);
		
	}
	
}
