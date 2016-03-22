package com.blinddealercasino;

import javax.swing.JButton;
/** 
 * 
 * Ma³a klasa, dziêki której layout paneluZNumeramiX dobrze pozycjonuje pozosta³e elementy GUI 
 * w tym panelu.  
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */



public class BrickButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180431185494581785L;

	public int polozenie;

	public BrickButton(int u) {
		polozenie = u;
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

}
