
package com.blinddealercasino;

import java.util.ArrayList;

/** 
 * Klasa Zak�adu odpowiadaj�ca czarnym numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class Czarne extends SzansaProsta {

	protected ArrayList<Numer> czarneNumery;

	public Czarne(int d) {
		super(d);
		czarneNumery = new ArrayList<Numer>();

	}
}
