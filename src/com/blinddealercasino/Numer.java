/**
 * 
 */
package com.blinddealercasino;

/** 
 * Rozszerzenie klasy zak³ad dla numerów (jeden numer). Przekazywane jest on w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numerów konieczne jest skorzystanie z 
 * gettera, by dowiedzieæ siê, czy dany zak³ad wygra³.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */
public class Numer extends Zaklad {

	private int numerek;

	public Numer(int i) {
		numerek = i;
	}

	public int getNumerek() {
		return numerek;
	}

}