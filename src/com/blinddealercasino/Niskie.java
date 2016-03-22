package com.blinddealercasino;

import java.util.ArrayList;



/** 
 * Klasa Zak³adu odpowiadaj¹ca niskim numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Niskie extends SzansaProsta {

	protected ArrayList<Numer> niskieNumery;

	public Niskie(int d) {
		super(d);
		niskieNumery = new ArrayList<Numer>();

	}
}
