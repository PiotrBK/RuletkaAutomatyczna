package com.blinddealercasino;

/** 
 * Rozszerzenie klasy zak�ad dla strit�w (trzy numery). Owe numery przekazywane s� w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numer�w konieczne jest skorzystanie z 
 * gettera, by dowiedzie� si�, czy dany zak�ad wygra�.
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class Strit extends Zaklad {

	private int numer1;
	private int numer2;
	private int numer3;

	public Strit(int i, int j, int k) {

		numer1 = i;
		numer2 = j;
		numer3 = k;
	}

	public int getNumer1() {
		return numer1;
	}

	public int getNumer2() {
		return numer2;
	}

	public int getNumer3() {
		return numer3;
	}

}
