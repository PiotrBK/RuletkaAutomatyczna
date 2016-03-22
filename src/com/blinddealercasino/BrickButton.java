package com.blinddealercasino;

import javax.swing.JButton;
/** 
 * 
 * Ma�a klasa, dzi�ki kt�rej layout paneluZNumeramiX dobrze pozycjonuje pozosta�e elementy GUI 
 * w tym panelu.  
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
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
