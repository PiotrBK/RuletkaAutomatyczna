package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak³adu odpowiadaj¹ca parzystym numerom. Nast¹pi³a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale¿y do danej szansy, wiêc na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class Parzyste extends SzansaProsta {

	protected ArrayList<Numer> parzysteNumery;

	public Parzyste(int d) {
		super(d);
		parzysteNumery = new ArrayList<Numer>();

	}

}
