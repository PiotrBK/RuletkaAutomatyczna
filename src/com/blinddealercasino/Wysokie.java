package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak³adu odpowiadaj¹ca wysokim numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Wysokie extends SzansaProsta {

	protected ArrayList<Numer> wysokieNumery;

	public Wysokie(int d) {
		super(d);
		wysokieNumery = new ArrayList<Numer>();

	}
}
