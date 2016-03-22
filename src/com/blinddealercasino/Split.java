package com.blinddealercasino;

/** 
 * Rozszerzenie klasy zak�ad dla split�w (dwa numery). Owe numery przekazywane s� w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numer�w konieczne jest skorzystanie z 
 * gettera, by dowiedzie� si�, czy dany zak�ad wygra�.
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
