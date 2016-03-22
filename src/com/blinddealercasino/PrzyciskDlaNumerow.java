package com.blinddealercasino;

/** 
 * Klasa przycisków odpowiadających za zakład na jeden numer.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyński-Kaczmarek
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
