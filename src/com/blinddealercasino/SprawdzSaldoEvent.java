package com.blinddealercasino;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz dokonuje obstawienia na planszy i aplikacja 
 * musi sprawdzi�, czy obstawienie jest poprawne pod k�tem obstawionej kwoty.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


import java.util.EventObject;

public class SprawdzSaldoEvent extends EventObject {

	
	private static final long serialVersionUID = -380663679403180385L;
	
	int wartoscObstawienia;
	public SprawdzSaldoEvent(Object source, int wartosc){
		super(source);
		this.wartoscObstawienia = wartosc;
	}
	
	public int getWartoscObstawienia(){
		return wartoscObstawienia;
	}
	
}
