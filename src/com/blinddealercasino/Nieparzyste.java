package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak³adu odpowiadaj¹ca nieparzystym numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */
public class Nieparzyste extends SzansaProsta {

	protected ArrayList<Numer> nieparzysteNumery;

	public Nieparzyste(int d) {
		super(d);
		nieparzysteNumery = new ArrayList<Numer>();

	}
}
