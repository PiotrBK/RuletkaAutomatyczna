package com.blinddealercasino;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** 
 * Klasa g��wna aplikacji. St�d uruchamiany jest graficzny interfejs u�ytkownika.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public class RuletkaGra {


	// metoda g��wna
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				JFrame ramkaGlowna = new MainFrame("Ruletka Ameryka�ska - BlindDealerCasino");
				ramkaGlowna.setSize(1100, 700);
				ramkaGlowna.setVisible(true);
			}

		});

	}
}
