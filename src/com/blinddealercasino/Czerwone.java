package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak�adu odpowiadaj�ca czerwonym numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public class Czerwone extends SzansaProsta {

	protected ArrayList<Numer> czerwoneNumery;

	public Czerwone(int d) {
		super(d);
		czerwoneNumery = new ArrayList<Numer>();

	}

}
