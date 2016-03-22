package com.blinddealercasino;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** 
 * Klasa g³ówna aplikacji. St¹d uruchamiany jest graficzny interfejs u¿ytkownika.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class RuletkaGra {


	// metoda g³ówna
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				JFrame ramkaGlowna = new MainFrame("Ruletka Amerykañska - BlindDealerCasino");
				ramkaGlowna.setSize(1100, 700);
				ramkaGlowna.setVisible(true);
			}

		});

	}
}
