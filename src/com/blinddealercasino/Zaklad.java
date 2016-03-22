package com.blinddealercasino;

/** 
 * Klasa abstrakcyjna, która stanowi podstawê obstawiania przez gracza poszczególnych zak³adów.
 * Stanowi bazê, z metod której korzystaj¹ wszystkie potomne klasy zak³adów.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public abstract class Zaklad {

	private int wartoscObstawienia;
	private int kwotaZakladu;
	private int poprzedniaKwotaZakladu;
	
	public void setWielkoscObstawienia(int s) {
		wartoscObstawienia = s;
		kwotaZakladu = kwotaZakladu + wartoscObstawienia;
		poprzedniaKwotaZakladu = kwotaZakladu;
	}

	public void setKwotaZakladu(int k) {
		kwotaZakladu = k;

	}

	public int getKwotaZakladu() {
		return kwotaZakladu;
	}
	
	public void rebetKwotaZakladu(int kwotaPrzekazana){
		kwotaZakladu = kwotaPrzekazana;
		poprzedniaKwotaZakladu = kwotaZakladu;
		
	}
	
	public void rebet2xKwotaZakladu(int kwotaPrzekazana){
		kwotaZakladu = kwotaPrzekazana;
		poprzedniaKwotaZakladu = kwotaZakladu;
		
	}

	public void zerujPoprzedniaKwote(){
		if (kwotaZakladu == 0){
		poprzedniaKwotaZakladu = 0;
		
		}
	}
	
	public int getPoprzedniaKwota(){
		return poprzedniaKwotaZakladu;
	}
}
