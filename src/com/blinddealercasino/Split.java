package com.blinddealercasino;

/** 
 * Rozszerzenie klasy zak³ad dla splitów (dwa numery). Owe numery przekazywane s¹ w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numerów konieczne jest skorzystanie z 
 * gettera, by dowiedzieæ siê, czy dany zak³ad wygra³.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Split extends Zaklad {

	private int numer1;
	private int numer2;

	public Split(int i, int j) {

		numer1 = i;
		numer2 = j;

	}

	public int getNumer1() {
		return numer1;
	}

	public int getNumer2() {
		return numer2;
	}
}
