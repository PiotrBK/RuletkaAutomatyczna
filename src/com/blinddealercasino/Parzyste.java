package com.blinddealercasino;

import java.util.ArrayList;


/** 
 * Klasa Zak�adu odpowiadaj�ca parzystym numerom. Nast�pi�a jednak zmiana koncepcji
 * sprawdzania, czy wygrany numer nale�y do danej szansy, wi�c na razie nie jest
 * odpowiednio wykorzystywana
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class Parzyste extends SzansaProsta {

	protected ArrayList<Numer> parzysteNumery;

	public Parzyste(int d) {
		super(d);
		parzysteNumery = new ArrayList<Numer>();

	}

}
