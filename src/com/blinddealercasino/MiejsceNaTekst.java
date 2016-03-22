package com.blinddealercasino;

import javax.swing.JTextArea;


/** 
 *
 * Klasa, która odpowiada za przekazywanie graczowi istotnych informacji w formie tekstowej.
 * Informuje o wysokoœci wygranej, braku œrodków do obstawiania, czy rozpoczêciu nowej gry. 
 *
 *
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class MiejsceNaTekst extends JTextArea {

	

	private static final long serialVersionUID = 6564019607344087202L;
	private String komunikatyBrakSrodkow[] = {"Brak œrodków. Nie mo¿esz obstawiaæ pieniêdzy, których nie masz.", "Za wiele chcia³byœ obstawiæ. Mo¿esz zawcze rozpocz¹æ now¹ grê", "Nie masz tylu œrodków na koncie."};
	private String komunikatyOWygranej[] = {"Gratulacje! W³aœnie wygra³eœ ", "To by³ szczêœliwy rzut! Wygra³eœ ", "Bardzo dobre obstawienia! Dziêki nim masz "};  
	private String komunikatyOPorazce[] = {"Tym razem siê nie uda³o. Spróbuj jeszcze raz!", "Nastêpnym razem na pewno bêdzie lepiej", "Nie pozwól siê tak ³atwo zniechêciæ. Fortuna czeka na Ciebie.", "Na pecha nic siê nie poradzi. Mo¿e tym razem siê uda...", "Spróbuj jeszcze raz!", "By³o tak blisko... Prawie jednak robi ró¿nicê. Spróbuj ponownie.", "Có¿, nie uda³o siê. Ale ile jest przy tym zabawy!"};
	private String komunikatyOZwrotach[] = {"Trafienie jest...ale chyba obstawi³eœ wiêcej. Wyp³ata to: ", "To w³aœciwie tylko czêœciowy zwrot. Twoja wyp³ata to: ", "Obstawi³eœ znacznie wiêcej, ale có¿...Oto Twoje ", "Rozwa¿ nie obstawianie wszystkich numerów. Twoje "};
	
	
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
		append(komunikatOWygranej + Integer.toString(kwotaWygranej) + " z³! \n");
		
	}
	
	public void appendKomunikatOZwrotach(int kwotaWygranej){
		String komunikatOZwrotach = null;
		int liczba = (int)(Math.random()*4);
		komunikatOZwrotach = komunikatyOZwrotach[liczba];
		append(komunikatOZwrotach + Integer.toString(kwotaWygranej) + " z³! \n");
	}
	
	public void appendBrakObstawien(){
		append("Tym razem nie obstawia³eœ. Szkoda, na pewno byœ trafi³! \n");
		
	}
	
	public void appendKomunikatOPorazce(){	
		String komunikatOPorazce = null;
		int liczba = (int) (Math.random()*7);
		komunikatOPorazce = komunikatyOPorazce[liczba];
		append(komunikatOPorazce +" \n");
		
	}
	
	public void appendNowaGra(){
		append("Mo¿esz zacz¹æ obstawianie. Masz do dyspozycji 1000 z³. Powodzenia! \n");
		
	}
	
	public void appendPowyzejMaksimum(){
		append("Maksimum na szanse proste, kolumny i tuziny wynosi 1500 z³. \nMaksimum na pozosta³e zak³ady to 500 z³. \n");
	}
	
	public void appendPonizejMaksimum(){
		append("Minimum na szanse proste, kolumny i tuziny to 50 z³\n");
	}

	public void appendKomunikatBlokady() {
		append("Kliknij przycisk 'NOWE', by obstawiæ nowe zak³ady\n");
		
	}

	public void appendZakladyDoMaksimum(){
		append("Zak³ady graj¹ tylko do maksimum sto³u!\n");
	}
	
	
}
