package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz kliknie któryœ z przycisków odpowiadajacych za 
 * zmianê stawki. Przechowuje zmienn¹ wartoscStawki, umo¿liwia jej pobranie poprzez getter.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class ZmianaStawkiEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4608370746778468167L;
	private int wartoscStawki;
	
	public ZmianaStawkiEvent(Object source, int wartoscStawki) {
		super(source);
		this.wartoscStawki = wartoscStawki;
	}
	
	public int getWartoscStawki(){
		return wartoscStawki;
	}
}
