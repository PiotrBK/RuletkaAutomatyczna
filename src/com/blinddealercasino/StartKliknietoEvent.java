package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz kliknie przycisk start. Zdarzenie odpala 
 * metod� losuj�c� w mainFrame.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public class StartKliknietoEvent extends EventObject {


	private static final long serialVersionUID = 3865750263942006333L;

	public StartKliknietoEvent(Object source) {
		super(source);

	}
	

}
