package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak�adu odpowiadaj�ca nieparzystym numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */
public class Nieparzyste extends SzansaProsta {

	protected ArrayList<Numer> nieparzysteNumery;

	public Nieparzyste(int d) {
		super(d);
		nieparzysteNumery = new ArrayList<Numer>();

	}
}
