package com.blinddealercasino;

import java.util.EventObject;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz kliknie kt�ry� z przycisk�w odpowiadajacych za 
 * zmian� stawki. Przechowuje zmienn� wartoscStawki, umo�liwia jej pobranie poprzez getter.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
