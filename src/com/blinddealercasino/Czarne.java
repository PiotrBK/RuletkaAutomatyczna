
package com.blinddealercasino;

import java.util.ArrayList;

/** 
 * Klasa Zak³adu odpowiadaj¹ca czarnym numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Czarne extends SzansaProsta {

	protected ArrayList<Numer> czarneNumery;

	public Czarne(int d) {
		super(d);
		czarneNumery = new ArrayList<Numer>();

	}
}
