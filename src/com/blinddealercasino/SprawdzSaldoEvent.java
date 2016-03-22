package com.blinddealercasino;

/** 
 * Klasa obiektu zdarzenia generowanego, gdy gracz dokonuje obstawienia na planszy i aplikacja 
 * musi sprawdziæ, czy obstawienie jest poprawne pod k¹tem obstawionej kwoty.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
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
