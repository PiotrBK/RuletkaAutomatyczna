package com.blinddealercasino;


/** 
 * Rozszerzenie klasy zak³ad dla sixlinów (szeœæ numerów). Owe numery przekazywane s¹ w konstruktorze
 * gdy obiekt jest tworzony, a podczas sprawdzania wygranych numerów konieczne jest skorzystanie z 
 * gettera, by dowiedzieæ siê, czy dany zak³ad wygra³.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class SixLine extends Zaklad {

	private int numer1;
	private int numer2;
	private int numer3;
	private int numer4;
	private int numer5;
	private int numer6;

	public SixLine(int i, int j, int k, int l, int m, int n) {

		numer1 = i;
		numer2 = j;
		numer3 = k;
		numer4 = l;
		numer5 = m;
		numer6 = n;
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

	public int getNumer5() {
		return numer5;
	}

	public int getNumer6() {
		return numer6;
	}
}
