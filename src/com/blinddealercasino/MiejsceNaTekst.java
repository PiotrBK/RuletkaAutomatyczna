package com.blinddealercasino;

import javax.swing.JTextArea;


/** 
 *
 * Klasa, kt�ra odpowiada za przekazywanie graczowi istotnych informacji w formie tekstowej.
 * Informuje o wysoko�ci wygranej, braku �rodk�w do obstawiania, czy rozpocz�ciu nowej gry. 
 *
 *
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public class MiejsceNaTekst extends JTextArea {

	

	private static final long serialVersionUID = 6564019607344087202L;
	private String komunikatyBrakSrodkow[] = {"Brak �rodk�w. Nie mo�esz obstawia� pieni�dzy, kt�rych nie masz.", "Za wiele chcia�by� obstawi�. Mo�esz zawcze rozpocz�� now� gr�", "Nie masz tylu �rodk�w na koncie."};
	private String komunikatyOWygranej[] = {"Gratulacje! W�a�nie wygra�e� ", "To by� szcz�liwy rzut! Wygra�e� ", "Bardzo dobre obstawienia! Dzi�ki nim masz "};  
	private String komunikatyOPorazce[] = {"Tym razem si� nie uda�o. Spr�buj jeszcze raz!", "Nast�pnym razem na pewno b�dzie lepiej", "Nie pozw�l si� tak �atwo zniech�ci�. Fortuna czeka na Ciebie.", "Na pecha nic si� nie poradzi. Mo�e tym razem si� uda...", "Spr�buj jeszcze raz!", "By�o tak blisko... Prawie jednak robi r�nic�. Spr�buj ponownie.", "C�, nie uda�o si�. Ale ile jest przy tym zabawy!"};
	private String komunikatyOZwrotach[] = {"Trafienie jest...ale chyba obstawi�e� wi�cej. Wyp�ata to: ", "To w�a�ciwie tylko cz�ciowy zwrot. Twoja wyp�ata to: ", "Obstawi�e� znacznie wi�cej, ale c�...Oto Twoje ", "Rozwa� nie obstawianie wszystkich numer�w. Twoje "};
	
	
	public MiejsceNaTekst(int liczba1, int liczba2){
		super(liczba1, liczba2);
	}

	public void appendKomunikatBrakSrodkow(){
		String komunikatBrakSrodkow = null;
		int liczba = (int)(Math.random()*3);
		komunikatBrakSrodkow = komunikatyBrakSrodkow[liczba];
		append(komunikatBrakSrodkow +" \n");
		
	}
	
	public void appendKomunikatOWygranej(int kwotaWygranej){
		String komunikatOWygranej = null;
		int liczba = (int) (Math.random()*3);
		komunikatOWygranej = komunikatyOWygranej[liczba];
		append(komunikatOWygranej + Integer.toString(kwotaWygranej) + " z�! \n");
		
	}
	
	public void appendKomunikatOZwrotach(int kwotaWygranej){
		String komunikatOZwrotach = null;
		int liczba = (int)(Math.random()*4);
		komunikatOZwrotach = komunikatyOZwrotach[liczba];
		append(komunikatOZwrotach + Integer.toString(kwotaWygranej) + " z�! \n");
	}
	
	public void appendBrakObstawien(){
		append("Tym razem nie obstawia�e�. Szkoda, na pewno by� trafi�! \n");
		
	}
	
	public void appendKomunikatOPorazce(){	
		String komunikatOPorazce = null;
		int liczba = (int) (Math.random()*7);
		komunikatOPorazce = komunikatyOPorazce[liczba];
		append(komunikatOPorazce +" \n");
		
	}
	
	public void appendNowaGra(){
		append("Mo�esz zacz�� obstawianie. Masz do dyspozycji 1000 z�. Powodzenia! \n");
		
	}
	
	public void appendPowyzejMaksimum(){
		append("Maksimum na szanse proste, kolumny i tuziny wynosi 1500 z�. \nMaksimum na pozosta�e zak�ady to 500 z�. \n");
	}
	
	public void appendPonizejMaksimum(){
		append("Minimum na szanse proste, kolumny i tuziny to 50 z�\n");
	}

	public void appendKomunikatBlokady() {
		append("Kliknij przycisk 'NOWE', by obstawi� nowe zak�ady\n");
		
	}

	public void appendZakladyDoMaksimum(){
		append("Zak�ady graj� tylko do maksimum sto�u!\n");
	}
	
	
}
