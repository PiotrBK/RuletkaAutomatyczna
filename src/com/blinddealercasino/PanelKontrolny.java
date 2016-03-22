package com.blinddealercasino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.EventListenerList;

/**
 * Ten Panel rozszerzaj¹cy klasê JPanel zawiera przyciski s³u¿¹ce do zarz¹dzania 
 * obstawieniami przez gracza. Gracz mo¿e zmieniæ stawkê, powtórzyæ poprzedni zak³ad,
 * podwoiæ poprzedni zak³ad, cofn¹æ obstawienie i wyczyœciæ wszystkie swoje zak³ady.
 * Gracz tutaj bêdzie decydowaæ o rozpoczêciu rundy("rzut kulk¹"), a tak¿e o rozpoczêciu 
 * nowych obstawieñ. Tutaj tak¿e jest podawana informacja o dostêpnych œrodkach.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */



public class PanelKontrolny extends JPanel {



	private static final long serialVersionUID = -6479588022209770745L;
	private JPanel panelTekstowy;
	private JPanel panelWartosciObstawien;
	protected JTextField saldo;
	private MiejsceNaTekst miejsceNaTekst;
	private int wartoscSalda;	
	private JButton start;
	private JButton wyczysc;
	private JButton cofnij;
	private JButton rebet;
	private JButton rebet2x;
	private JButton noweObstawienia;
	private JButton obstawienie10zl;
	private JButton obstawienie20zl;
	private JButton obstawienie50zl;
	private JButton obstawienie100zl;
	private JButton obstawienie500zl;
	private ImageIcon icObrazek10;
	private Image obrazek10;
	private ImageIcon icObrazek20;
	private Image obrazek20;
	private ImageIcon icObrazek50;
	private Image obrazek50;
	private ImageIcon icObrazek100;
	private Image obrazek100;
	private ImageIcon icObrazek500;
	private Image obrazek500;
	private Image obrazekStart;
	private ImageIcon icObrazekStart;	
	private ImageIcon icObrazekCofnij;
	private Image obrazekCofnij;
	private Image obrazekNowe;
	private ImageIcon icObrazekNowe;
	private EventListenerList listenerCofnijList = new EventListenerList();
	private EventListenerList listenerRebetList = new EventListenerList();
	private EventListenerList listenerRebet2xList = new EventListenerList();
	private EventListenerList listenerStartList = new EventListenerList();
	private EventListenerList listenerList = new EventListenerList();
	private EventListenerList listenerWyczyscList = new EventListenerList();
	private EventListenerList listenerNoweObstawieniaList = new EventListenerList();
	private Image obrazekWyczysc;
	private ImageIcon icObrazekWyczysc;
	private Image obrazekRebet;
	private ImageIcon icObrazekRebet;
	private Image obrazekRebet2x;
	private ImageIcon icObrazekRebet2x;

	
	
	
	public PanelKontrolny() {
		super();
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		Color kolorekNaTlo = new Color(0, 82, 0);
		setBackground(kolorekNaTlo);

		// stworzenie miejsca, gdzie wyœwietlane bêd¹ komentarze odnoœnie gry
		panelTekstowy = new JPanel();
		panelTekstowy.setBackground(kolorekNaTlo);
		panelTekstowy.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		miejsceNaTekst = new MiejsceNaTekst(10, 40);
		Color kolorekNaTekst = new Color(0, 112, 0);
		miejsceNaTekst.setBackground(kolorekNaTekst);
		Font naPanelZTekstem = new Font("sanserif", Font.PLAIN, 16);
		miejsceNaTekst.setFont(naPanelZTekstem);
		miejsceNaTekst.setForeground(Color.WHITE);
		miejsceNaTekst.setEditable(false);
		miejsceNaTekst.append("Witaj przy stole do ruletki! Który numer oka¿e siê dziœ Twoim szczêœliwym? \n");
		miejsceNaTekst.append("By zacz¹æ now¹ grê kliknij na menu Plik i wybierz odpowiedni¹ opcjê! \n");

		// dodanie przewijania, by u¿ytkownik móg³ ³atwo sprawdziæ wczeœniejsze
		// informacje
		JScrollPane przewijanie = new JScrollPane(miejsceNaTekst);
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelTekstowy.add(przewijanie);
		add(panelTekstowy, BorderLayout.EAST);
		
		// stworzenie panelu z wyborem wartoœci ¿etonu i miejscem, w którym bêdzie wyœwietlane dostêpne saldo
		
		panelWartosciObstawien = new JPanel();
		panelWartosciObstawien.setBackground(kolorekNaTlo);
		panelWartosciObstawien.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// stworzenie przyciskow odpowiedzialnych za wartoœæ obstawienia(¿etonu)
		// przycisk 10 z³
		
		obstawienie10zl = new JButton();
		obstawienie10zl.setBackground(kolorekNaTlo);
		obstawienie10zl.setVisible(false);
		obstawienie10zl.setEnabled(false);

		
		try {
			obrazek10 = null;
			obrazek10 = ImageIO.read(this.getClass().getResource("Zeton10zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek10 = new ImageIcon(obrazek10);
		obstawienie10zl.setIcon(icObrazek10);
		obstawienie10zl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int wartoscZetonu = 10;
				
				fireZmianaStawkiEvent(new ZmianaStawkiEvent(this, wartoscZetonu));
				
			}
			
		});
		
		// przycisk 20 z³
		
		obstawienie20zl = new JButton();
		obstawienie20zl.setBackground(kolorekNaTlo);
		obstawienie20zl.setVisible(false);
		obstawienie20zl.setEnabled(false);
		
		try {
			obrazek20 = null;
			obrazek20 = ImageIO.read(this.getClass().getResource("Zeton20zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek20 = new ImageIcon(obrazek20);
		obstawienie20zl.setIcon(icObrazek20);
		obstawienie20zl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int wartoscZetonu = 20;
				
				fireZmianaStawkiEvent(new ZmianaStawkiEvent(this, wartoscZetonu));
				
			}
			
		});
		
		
		//przycisk 50 z³
	
		obstawienie50zl = new JButton();
		obstawienie50zl.setBackground(kolorekNaTlo);
		obstawienie50zl.setVisible(false);
		obstawienie50zl.setEnabled(false);
		
		try {
			obrazek50 = null;
			obrazek50 = ImageIO.read(this.getClass().getResource("Zeton50zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek50 = new ImageIcon(obrazek50);
		obstawienie50zl.setIcon(icObrazek50);
		obstawienie50zl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int wartoscZetonu = 50;
				
				fireZmianaStawkiEvent(new ZmianaStawkiEvent(this, wartoscZetonu));
				
			}
			
		});
		
		//przycisk 100 z³
		
		obstawienie100zl = new JButton();
		obstawienie100zl.setBackground(kolorekNaTlo);
		obstawienie100zl.setVisible(false);
		obstawienie100zl.setEnabled(false);
		
		try {
			obrazek100 = null;
			obrazek100 = ImageIO.read(this.getClass().getResource("Zeton100zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek100 = new ImageIcon(obrazek100);
		obstawienie100zl.setIcon(icObrazek100);
		obstawienie100zl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int wartoscZetonu = 100;
				
				fireZmianaStawkiEvent(new ZmianaStawkiEvent(this, wartoscZetonu));
				
			}
			
		});
		
		//przycisk 500 z³
		
		
		obstawienie500zl = new JButton();
		obstawienie500zl.setBackground(kolorekNaTlo);
		obstawienie500zl.setVisible(false);
		obstawienie500zl.setEnabled(false);
		
		try {
			obrazek500 = null;
			obrazek500 = ImageIO.read(this.getClass().getResource("Zeton500zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek500 = new ImageIcon(obrazek500);
		obstawienie500zl.setIcon(icObrazek500);
		obstawienie500zl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int wartoscZetonu = 500;
				
				fireZmianaStawkiEvent(new ZmianaStawkiEvent(this, wartoscZetonu));
				
			}
			
		});
		
		// przycisk odpowiedzialny za losowanie wygrywaj¹cego numeru
		
		start = new JButton();
		start.setVisible(false);
		start.setEnabled(false);
		Color kolorStart = new Color(255,0,0);
		start.setBackground(kolorStart);
		try {
			obrazekStart = null;
			obrazekStart = ImageIO.read(this.getClass().getResource("start.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekStart = new ImageIcon(obrazekStart);
		start.setIcon(icObrazekStart);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				fireStartKliknietoEvent(new StartKliknietoEvent(this));
				
				
			}
		});
		
		// przycisk odpowiadaj¹cy za cofniêcie ostatniego obstawienia
		cofnij = new JButton();
		cofnij.setVisible(false);
		cofnij.setEnabled(false);
		cofnij.setBackground(Color.BLACK);
		
		try {
			obrazekCofnij = null;
			obrazekCofnij = ImageIO.read(this.getClass().getResource("cofnij.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekCofnij = new ImageIcon(obrazekCofnij);
		cofnij.setIcon(icObrazekCofnij);
		
		cofnij.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				fireCofnijKliknietoEvent(new CofnijKliknietoEvent(this));
			}
		});
		
		wyczysc = new JButton();
		wyczysc.setVisible(false);
		wyczysc.setEnabled(false);
		wyczysc.setBackground(Color.BLACK);
		
		try {
			obrazekWyczysc = null;
			obrazekWyczysc = ImageIO.read(this.getClass().getResource("wyczysc.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekWyczysc = new ImageIcon(obrazekWyczysc);
		wyczysc.setIcon(icObrazekWyczysc);
		
		wyczysc.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				fireWyczyscKliknietoEvent(new WyczyscKliknietoEvent(this));
			}
		});
		
		// przycisk nowe obstawienia
		
		noweObstawienia = new JButton();
		noweObstawienia.setVisible(false);
		noweObstawienia.setEnabled(false);
		Color naNowe = new Color(255,33,51);
		noweObstawienia.setBackground(naNowe);
		
		try {
			obrazekNowe = null;
			obrazekNowe = ImageIO.read(this.getClass().getResource("noweObstawienia.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekNowe = new ImageIcon(obrazekNowe);
		noweObstawienia.setIcon(icObrazekNowe);
		
		noweObstawienia.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				fireNoweObstawieniaEvent(new NoweObstawieniaEvent(this));
			}
		});

		// przycisk rebet
		
		rebet = new JButton();
		rebet.setVisible(false);
		rebet.setEnabled(false);
		rebet.setBackground(Color.BLACK);
		
		try {
			obrazekRebet = null;
			obrazekRebet = ImageIO.read(this.getClass().getResource("rebet.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekRebet = new ImageIcon(obrazekRebet);
		rebet.setIcon(icObrazekRebet);
		rebet.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				fireRebetEvent(new RebetEvent(this));
			}
		});	
		
		// przycisk rebet2x
		
		
		rebet2x = new JButton();
		rebet2x.setVisible(false);
		rebet2x.setEnabled(false);
		rebet2x.setBackground(Color.BLACK);
		
		try {
			obrazekRebet2x = null;
			obrazekRebet2x = ImageIO.read(this.getClass().getResource("rebet2x.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazekRebet2x = new ImageIcon(obrazekRebet2x);
		rebet2x.setIcon(icObrazekRebet2x);
		rebet2x.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				fireRebet2xEvent(new Rebet2xEvent(this));
			}
		});	
		
		//etykieta i pole tekstowe SALDO
		
		JLabel etykietaSaldo = new JLabel();
		Font naEtykiete = new Font("sanserif", Font.BOLD, 22);
		etykietaSaldo.setFont(naEtykiete);
		etykietaSaldo.setForeground(Color.WHITE);
		etykietaSaldo.setBackground(kolorekNaTlo);
		etykietaSaldo.setText("SALDO:  ");
		
		saldo = new JTextField();
		saldo.setBackground(kolorekNaTlo);
		saldo.setBorder(null);
		saldo.setForeground(Color.WHITE);
		saldo.setFont(naEtykiete);
		saldo.setEditable(false);
		saldo.setText(Integer.toString(wartoscSalda) + " z³");
		

		
		//dodanie przycisków do panelu
		GridBagLayout layoutGrid = new GridBagLayout();
		panelWartosciObstawien.setLayout(layoutGrid);
		GridBagConstraints gc = new GridBagConstraints();
		gc.ipadx = 0;
		gc.ipady = 0;

		gc.fill = GridBagConstraints.PAGE_START;	
		gc.gridx = 0;
		gc.gridy = 0;
		panelWartosciObstawien.add(obstawienie10zl, gc);
				
		gc.gridx = 1;
		gc.gridy = 0;
		panelWartosciObstawien.add(obstawienie20zl, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		panelWartosciObstawien.add(obstawienie50zl, gc);
		
		gc.gridx = 3;
		gc.gridy = 0;
		panelWartosciObstawien.add(obstawienie100zl, gc);
		
		gc.gridx = 4;
		gc.gridy = 0;
		panelWartosciObstawien.add(obstawienie500zl, gc);
		
		gc.gridwidth = 2;
		gc.gridx = 5;
		gc.gridy = 0;
		panelWartosciObstawien.add(noweObstawienia, gc);
		

		
		gc.fill = GridBagConstraints.BOTH;
		gc.gridwidth = 2;
		gc.gridx = 5;
		gc.gridy = 0;
		panelWartosciObstawien.add(start, gc);
		
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 1;
		panelWartosciObstawien.add(rebet, gc);
		
		gc.gridwidth = 3;
		gc.gridx = 2;
		gc.gridy = 1;
		panelWartosciObstawien.add(rebet2x, gc);
		
		gc.gridwidth =2;
		gc.gridx = 5;
		gc.gridy = 1;
		panelWartosciObstawien.add(cofnij, gc);
			
		gc.gridwidth = 2;
		gc.gridx = 5;
		gc.gridy = 2;
		panelWartosciObstawien.add(wyczysc, gc);
		
		gc.fill = GridBagConstraints.LAST_LINE_END;
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 2;
		panelWartosciObstawien.add(etykietaSaldo, gc);
				
		gc.gridwidth = 3;
		gc.gridx = 3;
		gc.gridy = 2;
		panelWartosciObstawien.add(saldo, gc);

		//gc.gridwidth = 1;
		//gc.gridx = 0;
		//gc.gridy = 2;
		//panelWartosciObstawien.add(cegla, gc);
		

		
		
		add(panelWartosciObstawien, BorderLayout.WEST);
		
		
		
	}
	
	protected void fireRebet2xEvent(Rebet2xEvent event) {
		Object[]listeners = listenerRebet2xList.getListenerList();
		for (int i = 0; i < listeners.length; i +=2){
			if (listeners[i] == Rebet2xListener.class){
				((Rebet2xListener) listeners[i+1]).fireRebet2xEvent(event);
			}
		}
		
	}

	protected void fireRebetEvent(RebetEvent event) {
		Object[]listeners = listenerRebetList.getListenerList();
		for (int i = 0; i < listeners.length; i +=2){
			if (listeners[i] == RebetListener.class){
				((RebetListener) listeners[i+1]).fireRebetEvent(event);
			}
		}
		
	}

	public void fireCofnijKliknietoEvent(CofnijKliknietoEvent event){
		Object[]listeners = listenerCofnijList.getListenerList();
		for (int i = 0; i < listeners.length; i +=2){
			if (listeners[i] == CofnijKliknietoListener.class){
				((CofnijKliknietoListener) listeners[i+1]).cofnijKliknieto(event);
			}
		}
		
	}
	
	
	public void fireZmianaStawkiEvent(ZmianaStawkiEvent event){
		Object[]listeners = listenerList.getListenerList();
		for(int i = 0; i < listeners.length; i+=2){
			if (listeners[i] == ZmianaStawkiListener.class){
				((ZmianaStawkiListener) listeners[i+1]).zmianaStawkiOccured(event);
			}
		}
	}
	
	public void fireStartKliknietoEvent(StartKliknietoEvent event){
		Object[]listeners = listenerStartList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2){
			if(listeners[i]==StartListener.class){
				((StartListener) listeners[i+1]).startKliknieto(event);
			}
		}
		
	}
	
	public void fireWyczyscKliknietoEvent(WyczyscKliknietoEvent event){
		Object[]listeners = listenerWyczyscList.getListenerList();
		for (int i = 0; i < listeners.length; i +=2){
			if (listeners[i] == WyczyscKliknietoListener.class){
				((WyczyscKliknietoListener) listeners[i+1]).wyczyscKliknieto(event);
			}
		
		}		
			
	}
	
	public void fireNoweObstawieniaEvent(NoweObstawieniaEvent event){
		Object[]listeners = listenerNoweObstawieniaList.getListenerList();
		for (int i = 0; i < listeners.length; i +=2){
			if (listeners[i] == NoweObstawieniaListener.class){
				((NoweObstawieniaListener) listeners[i+1]).fireNoweObstawieniaEvent(event);
			}
		
		}	
	}
	
	//dodanie EventListenerow do panelu (start, cofnij, zmiana obstawienia, usun wszystkie obstawienia)
	public void addWyczyscKliknietoListener(WyczyscKliknietoListener listener){
		listenerWyczyscList.add(WyczyscKliknietoListener.class, listener);
	}
	
	public void removeWyczyscKliknietoListener(WyczyscKliknietoListener listener){
		listenerWyczyscList.remove(WyczyscKliknietoListener.class, listener);
	}
	
	
	public void addCofnijKliknietoListener(CofnijKliknietoListener listener){
		listenerCofnijList.add(CofnijKliknietoListener.class, listener);
	}
	
	public void removeCofnijKliknietoListener(CofnijKliknietoListener listener){
		listenerCofnijList.remove(CofnijKliknietoListener.class, listener);
	}
	
	public void addZmianaStawkiListener(ZmianaStawkiListener listener){
		listenerList.add(ZmianaStawkiListener.class, listener);
		
	}
	
	public void removeZmianaStawkiListener(ZmianaStawkiListener listener){
		listenerList.remove(ZmianaStawkiListener.class, listener);
	}
	
	public void addStartListener(StartListener listener){
		listenerStartList.add(StartListener.class, listener);
	}
	
	public void removeStartListener(StartListener listener){
		listenerStartList.remove(StartListener.class, listener);
	}
	
	public void addNoweObstawieniaListener(NoweObstawieniaListener listener){
		listenerNoweObstawieniaList.add(NoweObstawieniaListener.class, listener);
	}
	
	public void removeNoweObsawieniaListener(NoweObstawieniaListener listener){
		listenerNoweObstawieniaList.remove(NoweObstawieniaListener.class, listener);
	}
	public void addRebetListener(RebetListener listener){
		listenerRebetList.add(RebetListener.class, listener);
	}
	
	public void removeRebetListener(RebetListener listener){
		listenerRebetList.remove(RebetListener.class, listener);
	}
	
	public void addRebet2xListener(Rebet2xListener listener){
		listenerRebet2xList.add(Rebet2xListener.class, listener);
	}
	
	public void removeRebet2xListener(Rebet2xListener listener){
		listenerRebet2xList.remove(Rebet2xListener.class, listener);
	}
	
	public void refreshSaldo(){
		saldo.setText(Integer.toString(wartoscSalda) + " z³");
		
		
	}

	public void nowaGra(){
		enableStart();	
		disableCofnij();
		disableWyczysc();
		disableRebet();
		disableRebet2x();		
		disableNoweObstawienia();
		obstawienie10zl.setVisible(true);
		obstawienie20zl.setVisible(true);
		obstawienie50zl.setVisible(true);
		obstawienie100zl.setVisible(true);
		obstawienie500zl.setVisible(true);
		obstawienie10zl.setEnabled(true);
		obstawienie20zl.setEnabled(true);
		obstawienie50zl.setEnabled(true);
		obstawienie100zl.setEnabled(true);
		obstawienie500zl.setEnabled(true);
	}
	
	public void setWartoscSalda(int wartosc){
		wartoscSalda = wartosc;
	}
	
	public int getWartoscSalda(){
		return wartoscSalda;
	}
	
	public void disableCofnij(){
		cofnij.setEnabled(false);
		cofnij.setVisible(false);
	}
	
	public void enableCofnij(){
		cofnij.setEnabled(true);
		cofnij.setVisible(true);
	}
	
	public MiejsceNaTekst getMiejsceNaTekst(){
		return miejsceNaTekst;
	}
	
	public void disableWyczysc(){
		wyczysc.setVisible(false);
		wyczysc.setEnabled(false);
	}
	
	public void enableWyczysc(){
		wyczysc.setVisible(true);
		wyczysc.setEnabled(true);
	}

	public void enableNoweObstawienia(){
		noweObstawienia.setVisible(true);
		noweObstawienia.setEnabled(true);
	}
	public void disableNoweObstawienia(){
		noweObstawienia.setEnabled(false);
		noweObstawienia.setVisible(false);
	}
	
	public void enableRebet(){
		rebet.setEnabled(true);
		rebet.setVisible(true);
	}
	public void	disableRebet(){
		rebet.setEnabled(false);
		rebet.setVisible(false);
	}
	public void enableStart(){
		start.setEnabled(true);
		start.setVisible(true);
	}
	
	public void enableRebet2x(){
		rebet2x.setEnabled(true);
		rebet2x.setVisible(true);
	}
	
	public void	disableRebet2x(){
		rebet2x.setEnabled(false);
		rebet2x.setVisible(false);
	}

	
	public void disableStart(){
		start.setEnabled(false);
		start.setVisible(false);
	}
	
	
	
}
