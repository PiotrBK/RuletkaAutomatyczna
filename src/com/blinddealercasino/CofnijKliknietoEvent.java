package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Zdarzenie klikni�cia na przycisk cofnij w paneluKontrolnym
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class CofnijKliknietoEvent extends EventObject {
	
	
	private static final long serialVersionUID = -2776995305305241295L;

	public CofnijKliknietoEvent(Object source) {
		super(source);
	}
}
