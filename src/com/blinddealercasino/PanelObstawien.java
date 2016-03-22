package com.blinddealercasino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/** 
 * Klasa odpowiadaj¹ca za wyœwietlanie tablicy wyników. W niej jest te¿ zagnie¿d¿ony stó³ do gry 
 * w postaci paneluZNumeramiX. 
 * 
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class PanelObstawien extends JPanel {

	/**
	 * 
	 */
	protected JTextPane tablicaWynikow;
	private static final long serialVersionUID = 7826059078628335375L;
	protected PanelZNumeramiX panelZNumeramiX;
	private JPanel panelWynikow;
	protected Color kolorekNaTlo;
	protected Color kolorekNaTekst;
	protected Style style1;
	protected Style style2;
	protected Style style3;
	protected StyledDocument doc;

	public PanelObstawien() {
		// ustalenia dotycz¹ce rozmiaru
		Dimension size = getPreferredSize();
		size.width = 1500;
		size.height = 500;
		setPreferredSize(size);

		// ustawienie layout managera
		setLayout(new BorderLayout());

		// stworzenie koloru dla layoutu i pól tekstowych
		kolorekNaTlo = new Color(0, 82, 0);
		kolorekNaTekst = new Color(0, 112, 0);
		// stworzenie czcionki na etykiety
		Font dlaEtykiet = new Font("sanserif", Font.BOLD, 14);

		// stworzenie miejsca, gdzie wyœwietlane bêd¹ wygrane numery
		panelWynikow = new JPanel();
		panelWynikow.setBackground(kolorekNaTlo);
		panelWynikow.setLayout(new BorderLayout());
		panelWynikow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 30));
		JLabel labelMinimum = new JLabel("MIN 10 Z£");
		labelMinimum.setFont(dlaEtykiet);
		labelMinimum.setForeground(Color.WHITE);
		panelWynikow.add(labelMinimum, BorderLayout.NORTH);
		tablicaWynikow = new JTextPane();
		tablicaWynikow.setBackground(Color.WHITE);
		Font wygraneNumery = new Font("sanserif", Font.BOLD, 28);
		tablicaWynikow.setFont(wygraneNumery);

		// utworzenie stylów do wyœwietlania numerów czarnych i czerwonych

		doc = tablicaWynikow.getStyledDocument();
		style1 = tablicaWynikow.addStyle("I'm a Style", null);
		StyleConstants.setForeground(style1, Color.RED);

		try {
			doc.insertString(doc.getLength(), "23\n", style1);
		} catch (BadLocationException e) {
			System.err.println("To jaki by³ ostatni numer?");
		}

		style2 = tablicaWynikow.addStyle("I'm a style too", null);
		StyleConstants.setForeground(style2, Color.BLACK);
		try {
			doc.insertString(doc.getLength(), "24\n", style2);
		} catch (BadLocationException e) {
			System.err.println("To jaki by³ ostatni numer?");
		}

		style3 = tablicaWynikow.addStyle("I'm a style too", null);
		StyleConstants.setForeground(style3, Color.GREEN);
		try {
			doc.insertString(doc.getLength(), "0 \n", style3);
		} catch (BadLocationException e) {
			System.err.println("To jaki by³ ostatni numer?");
		}
		
		tablicaWynikow.setEditable(false);
		JScrollPane przewijanieNumerow = new JScrollPane(tablicaWynikow);
		przewijanieNumerow.setOpaque(false);
		przewijanieNumerow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		przewijanieNumerow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelWynikow.add(przewijanieNumerow, BorderLayout.CENTER);

		// stworzenie miejsca, gdzie bêdzie mo¿na obstawiaæ
		panelZNumeramiX = new PanelZNumeramiX();
		
		// dodanie paneli do g³ównego panelu obstawieñ
		add(panelWynikow, BorderLayout.WEST);
		add(panelZNumeramiX, BorderLayout.CENTER);

	}

}
