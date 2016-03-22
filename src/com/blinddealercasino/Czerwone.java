package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak³adu odpowiadaj¹ca czerwonym numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class Czerwone extends SzansaProsta {

	protected ArrayList<Numer> czerwoneNumery;

	public Czerwone(int d) {
		super(d);
		czerwoneNumery = new ArrayList<Numer>();

	}

}
