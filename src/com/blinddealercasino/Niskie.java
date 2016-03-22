package com.blinddealercasino;

import java.util.ArrayList;



/** 
 * Klasa Zak�adu odpowiadaj�ca niskim numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class Niskie extends SzansaProsta {

	protected ArrayList<Numer> niskieNumery;

	public Niskie(int d) {
		super(d);
		niskieNumery = new ArrayList<Numer>();

	}
}
