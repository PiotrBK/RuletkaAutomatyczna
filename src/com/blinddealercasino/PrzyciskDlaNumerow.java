package com.blinddealercasino;

/** 
 * Klasa przycisków odpowiadaj¹cych za zak³ad na jeden numer.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class PrzyciskDlaNumerow extends PrzyciskDlaRuletki {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7139419975446906788L;

	protected int numerDlaPrzycisku;

	public PrzyciskDlaNumerow(int d) {
		super(d);
		numerDlaPrzycisku = d;
	}
	

}
