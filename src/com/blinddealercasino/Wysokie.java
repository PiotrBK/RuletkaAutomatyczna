package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak�adu odpowiadaj�ca wysokim numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class Wysokie extends SzansaProsta {

	protected ArrayList<Numer> wysokieNumery;

	public Wysokie(int d) {
		super(d);
		wysokieNumery = new ArrayList<Numer>();

	}
}
