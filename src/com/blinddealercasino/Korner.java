package com.blinddealercasino;


/** 
 * Rozszerzenie klasy zak³ad dla kornerów (cztery numery). Owe numery przekazywane s¹ w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numerów konieczne jest skorzystanie z 
 * gettera, by dowiedzieæ siê, czy dany zak³ad wygra³.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class Korner extends Zaklad {
	private int numer1;
	private int numer2;
	private int numer3;
	private int numer4;

	public Korner(int i, int j, int k, int l) {

		numer1 = i;
		numer2 = j;
		numer3 = k;
		numer4 = l;
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

	public int getNumer4() {
		return numer4;
	}
}
