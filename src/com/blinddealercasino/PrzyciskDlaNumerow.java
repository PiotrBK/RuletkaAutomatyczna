package com.blinddealercasino;

/** 
 * Klasa przycisk�w odpowiadaj�cych za zak�ad na jeden numer.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
