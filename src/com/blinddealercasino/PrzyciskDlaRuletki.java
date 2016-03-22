package com.blinddealercasino;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/** 
 * Podstawowy budulec planszy do obstawiania zak³adów. 
 * Ka¿dy przyciskDlaRuletki odpowiada za okreœlony zak³ad. 
 * Zawiera metody umo¿liwiaj¹ce obstawienie ¿etonów w postaci ikony na poszczególnych przyciskach 
 * odpowiadaj¹ce wartoœci obstawienia na odpowiadaj¹cych im zak³adach. Jako zmienn¹ int posiadaj¹ 
 * równie¿ wartoœæ poprzedniego obstawienia umo¿liwiaj¹c¹ dokonanie takiego samego, 
 * lub podwojonego obstawienia.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public class PrzyciskDlaRuletki extends JButton {


	private static final long serialVersionUID = 5743767181828728069L;
	protected int numerArray;
	protected Image emptyZeton;
	protected ImageIcon icEmptyZeton;
	private int wartoscZetonu;
	@SuppressWarnings("unused")// u¿ywam poprzedniej kwoty do ustawienia odpowiedniej ikony poprzez ustawKwoteRebet, a setterem jest metoda "zeruj poprzedni¹ kwotê"
	private int poprzedniaKwota;

	
	
	public PrzyciskDlaRuletki(int d) {
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		numerArray = d;
		
		try {
			emptyZeton = null;
			emptyZeton = ImageIO.read(this.getClass().getResource("emptyZeton.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		icEmptyZeton = new ImageIcon(emptyZeton);
		setIcon(icEmptyZeton);
		

	}
	
	public void ustawIkone(int wartosc){
		wartoscZetonu = wartosc;
		if (wartoscZetonu == 0){
			this.setIcon(icEmptyZeton);
		}
		if ((wartoscZetonu > 0) &&(wartoscZetonu <=1000)){	
			Image obraz = null;
			try {
			
				obraz = ImageIO.read(this.getClass().getResource("Zeton"+Integer.toString(wartoscZetonu)+"zl.png"));
			} catch (IOException ex){
				ex.printStackTrace();
			}
			
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu>1000 & wartoscZetonu<1100){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1000zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
			
		}
		if (wartoscZetonu >=1100 & wartoscZetonu <1200){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1100zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1200 & wartoscZetonu <1300){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1200zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1300 & wartoscZetonu <1400){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1300zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >= 1400 & wartoscZetonu <1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1400zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu == 1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1500zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		poprzedniaKwota = wartoscZetonu;
	}
	
	public void ustawKwoteRebet(int wartosc){
		poprzedniaKwota = wartosc;
		wartoscZetonu = wartosc;
		if (wartoscZetonu == 0){
			this.setIcon(icEmptyZeton);
		}
		if ((wartoscZetonu > 0) && (wartoscZetonu <=1000)) {	
			Image obraz = null;
			try {
			
				obraz = ImageIO.read(this.getClass().getResource("Zeton"+Integer.toString(wartoscZetonu)+"zl.png"));
			} catch (IOException ex){
				ex.printStackTrace();
			}
			
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu>1000 & wartoscZetonu<1100){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1000zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
			
		}
		if (wartoscZetonu >=1100 & wartoscZetonu <1200){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1100zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1200 & wartoscZetonu <1300){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1200zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1300 & wartoscZetonu <1400){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1300zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >= 1400 & wartoscZetonu <1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1400zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu == 1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1500zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}

	}

	public void ustawKwoteRebet2x(int wartosc){
		
		poprzedniaKwota = wartosc;
		wartoscZetonu = wartosc;
		if (wartoscZetonu == 0){
			this.setIcon(icEmptyZeton);
		}
		if (wartoscZetonu > 0 && wartoscZetonu <= 1000){	
			Image obraz = null;
			try {
			
				obraz = ImageIO.read(this.getClass().getResource("Zeton"+Integer.toString(wartoscZetonu)+"zl.png"));
			} catch (IOException ex){
				ex.printStackTrace();
			}
			
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu>1000 & wartoscZetonu<1100){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1000zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
			
		}
		if (wartoscZetonu >=1100 & wartoscZetonu <1200){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1100zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1200 & wartoscZetonu <1300){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1200zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >=1300 & wartoscZetonu <1400){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1300zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu >= 1400 & wartoscZetonu <1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1400zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		if (wartoscZetonu == 1500){
			Image obraz = null;
			try {
				obraz = ImageIO.read(this.getClass().getResource("Zeton1500zl.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			ImageIcon ikona = new ImageIcon(obraz);			
			this.setIcon(ikona);
		}
		
		
	}
	
	public void podswietlicNumer(){
		

		Image obrazPodswietlony = null;
		if (wartoscZetonu<=1000){
			try {
			
				obrazPodswietlony = ImageIO.read(this.getClass().getResource("wygrany"+Integer.toString(wartoscZetonu)+"zl.png"));
				System.out.println(Integer.toString(wartoscZetonu));
			} catch (IOException ex){
				ex.printStackTrace();
			}
		
			ImageIcon ikona = new ImageIcon(obrazPodswietlony);			
			this.setIcon(ikona);
		
		}else{
			try {
				
				obrazPodswietlony = ImageIO.read(this.getClass().getResource("wygrany1000zl.png"));
			} catch (IOException ex){
				ex.printStackTrace();
			}
			
			ImageIcon ikona = new ImageIcon(obrazPodswietlony);			
			this.setIcon(ikona);
		}
		
	}

	public void zerujWartoscZetonu(){
		this.setIcon(icEmptyZeton);
		wartoscZetonu = 0;
		
	}
	
	public void zerujWartoscPoprzedniejKwoty(){
		if (wartoscZetonu == 0){
		poprzedniaKwota = 0;
		
		}
	}
	
	
	
}
