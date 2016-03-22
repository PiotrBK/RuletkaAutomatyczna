/**
 * 
 */
package com.blinddealercasino;

/** 
 * Rozszerzenie klasy zak�ad dla numer�w (jeden numer). Przekazywane jest on w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numer�w konieczne jest skorzystanie z 
 * gettera, by dowiedzie� si�, czy dany zak�ad wygra�.
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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