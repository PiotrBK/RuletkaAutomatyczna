package com.blinddealercasino;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

/** 
 * Najwa¿niejsza czêœæ interfejsu graficznego aplikacji, czyli stó³ do obstawiania zak³adów. 
 * W pierwszych wersjach ruletki by³y tylko cztery dostêpne do obstawienia zak³ady. 
 * Tutaj jest ich... du¿o. Za ka¿dy z nich odpowiada oddzielny przycisk rozszerzaj¹cy klasê JButton.
 * Przyciski nie mog¹ przechowywaæ wartoœci zak³adów - z prostej przyczyny - przycisk nie jest Zak³adem. 
 * Dlatego ka¿demu z przycisków odpowiada instancja abstrakcyjnej klasy zak³ad w formie dopasowanej do 
 * specyfiki zak³adu (iloœæ obstawianych numerów). Jeden zbiór kolekcji ArrayList zawiera przyciski,
 * drugi zawiera zak³ady. 
 * 
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class PanelZNumeramiX extends JPanel {


	private static final long serialVersionUID = 8137477262075900382L;
	protected ArrayList<PrzyciskDlaNumerow> tablicaPrzyciskowNumerow;
	protected ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowStritow;
	protected ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowSplitow;
	protected ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowKornerow;
	protected ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowSixLinow;
	protected ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowKolumnITuzinow;
	public ArrayList<PrzyciskDlaRuletki> tablicaPrzyciskowSzansProstych;
	protected ArrayList<Numer> tablicaNumerow;
	protected ArrayList<Strit> tablicaStritow;
	protected ArrayList<Split> tablicaSplitow;
	protected ArrayList<Korner> tablicaKornerow;
	protected ArrayList<SixLine> tablicaSixLinow;
	protected ArrayList<KolumnaITuzin> tablicaKolumnITuzinow;
	protected ArrayList<SzansaProsta> tablicaSzansProstych;
	protected BufferedImage bgImage;
	private int wartoscJednegoZetonu;
	protected Image obrazek10;
	protected ImageIcon icObrazek10;
	protected ImageIcon icObrazek20;
	protected Image obrazek20;
	protected ImageIcon icObrazek50;
	protected Image obrazek50;
	protected ImageIcon icObrazek100;
	protected Image obrazek100;
	protected ImageIcon icObrazek500;
	protected Image obrazek500;
	protected JButton przyciskAktualnejStawki;
	private EventListenerList dokonanoObstawieniaListenerList = new EventListenerList();
	private EventListenerList sprawdzSaldoListenerList = new EventListenerList();	
	private EventListenerList ponizejMinimumListenerList = new EventListenerList();
	private EventListenerList powyzejMaksimumListenerList = new EventListenerList();
	private boolean saSrodki;
	
	protected void paintComponent(Graphics g) {

		try {
			bgImage = null;
			bgImage = ImageIO.read(this.getClass().getResource("ruletkaTlo1.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		super.paintComponent(g);

		g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
	}

	public PanelZNumeramiX() {

		setBorder(BorderFactory.createEmptyBorder(22, 20, 0, 20));


		try {
			obrazek10 = null;
			obrazek10 = ImageIO.read(this.getClass().getResource("Zeton10zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		icObrazek10 = new ImageIcon(obrazek10);


		try {
			obrazek20 = null;
			obrazek20 = ImageIO.read(this.getClass().getResource("Zeton20zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek20 = new ImageIcon(obrazek20);
		
		
		try {
			obrazek50 = null;
			obrazek50 = ImageIO.read(this.getClass().getResource("Zeton50zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek50 = new ImageIcon(obrazek50);
		
		try {
			obrazek100 = null;
			obrazek100 = ImageIO.read(this.getClass().getResource("Zeton100zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek100 = new ImageIcon(obrazek100);
		
		try {
			obrazek500 = null;
			obrazek500 = ImageIO.read(this.getClass().getResource("Zeton500zl.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		icObrazek500 = new ImageIcon(obrazek500);
		
		// stworzenie Przycisków dla poszczególnych Numerów
		tablicaPrzyciskowNumerow = new ArrayList<PrzyciskDlaNumerow>();

		int d;

		for (d = 0; d < 37; d++) {
			PrzyciskDlaNumerow nowy = new PrzyciskDlaNumerow(d);
			tablicaPrzyciskowNumerow.add(nowy);
			nowy.addActionListener(new NumerListener(d));

		}
		// stworzenie tablic dla pozosta³ych Przyciskow
		tablicaPrzyciskowSplitow = new ArrayList<PrzyciskDlaRuletki>();
		tablicaPrzyciskowStritow = new ArrayList<PrzyciskDlaRuletki>();
		tablicaPrzyciskowKornerow = new ArrayList<PrzyciskDlaRuletki>();
		tablicaPrzyciskowSixLinow = new ArrayList<PrzyciskDlaRuletki>();
		tablicaPrzyciskowKolumnITuzinow = new ArrayList<PrzyciskDlaRuletki>();
		tablicaPrzyciskowSzansProstych = new ArrayList<PrzyciskDlaRuletki>();

		// stworzenie przycisków dla splitów
		int e;
		for (e = 0; e < 60; e++) {
			PrzyciskDlaRuletki nowosc = new PrzyciskDlaRuletki(e);
			tablicaPrzyciskowSplitow.add(nowosc);
			nowosc.addActionListener(new SplitListener(e));
			

		}
		// stworzenie przycisków dla stritów
		int f;
		for (f = 0; f < 14; f++) {
			PrzyciskDlaRuletki nowosc = new PrzyciskDlaRuletki(f);
			tablicaPrzyciskowStritow.add(nowosc);
			nowosc.addActionListener(new StritListener(f));
		}
		// stworzenie przycisków dla kornerów
		int g;
		for (g = 0; g < 23; g++) {
			PrzyciskDlaRuletki nowosc = new PrzyciskDlaRuletki(g);
			tablicaPrzyciskowKornerow.add(nowosc);
			nowosc.addActionListener(new KornerListener(g));
		}
		// stworzenie przycisków dla sixlinów
		int h;
		for (h = 0; h < 11; h++) {
			PrzyciskDlaRuletki nowosc = new PrzyciskDlaRuletki(h);
			tablicaPrzyciskowSixLinow.add(nowosc);
			nowosc.addActionListener(new SixLineListener(h));

		}

		// stworzenie przycisków Kolumn i Tuzinów
		int i;
		for (i = 0; i < 6; i++) {
			PrzyciskDlaRuletki tuzinKolumna = new PrzyciskDlaRuletki(i);
			tablicaPrzyciskowKolumnITuzinow.add(tuzinKolumna);
			tuzinKolumna.addActionListener(new KolumnaITuzinListener(i));
		
		}

		// stworzenie przycisków SzansProstych

		int j;
		for (j = 0; j < 6; j++) {
			PrzyciskDlaRuletki szansa = new PrzyciskDlaRuletki(j);
			tablicaPrzyciskowSzansProstych.add(szansa);
			szansa.addActionListener(new SzanseProsteListener(j));
		}
		
		PrzyciskDlaRuletki przyciskAktualnejStawki = new PrzyciskDlaRuletki(1000); 
		tablicaPrzyciskowSzansProstych.add(przyciskAktualnejStawki);
		przyciskAktualnejStawki.ustawIkone(10);
		

		// stworzenie tablic dla zak³adów
		tablicaNumerow = new ArrayList<Numer>();
		tablicaSplitow = new ArrayList<Split>();
		tablicaKornerow = new ArrayList<Korner>();
		tablicaStritow = new ArrayList<Strit>();
		tablicaSixLinow = new ArrayList<SixLine>();
		tablicaKolumnITuzinow = new ArrayList<KolumnaITuzin>();
		tablicaSzansProstych = new ArrayList<SzansaProsta>();

		// stworzenie i dodanie layoutu, który bêdzie mo¿na wykorzystaæ w celu
		// dodawania numerów
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.ipadx = 1;
		gc.ipady = 1;
		gc.fill = GridBagConstraints.BOTH;

		// pierwsza kolumna przeznaczona na numer 0
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridheight = 11;
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(0), gc);
		final Numer zero = new Numer(0);
		tablicaNumerow.add(zero);

		// druga kolumna

		gc.gridheight = 3;
		gc.gridwidth = 3;
		gc.gridx = 2;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(0), gc);
		final Split zeroTrzy = new Split(0, 3);
		tablicaSplitow.add(zeroTrzy);

		gc.gridx = 2;
		gc.gridy = 2;
		add(tablicaPrzyciskowStritow.get(0), gc);
		final Strit zeroDwaTrzy = new Strit(0, 2, 3);
		tablicaStritow.add(zeroDwaTrzy);

		gc.gridx = 2;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(1), gc);
		final Split zeroDwa = new Split(0, 2);
		tablicaSplitow.add(zeroDwa);
		
		gc.gridx = 2;
		gc.gridy = 6;
		add(tablicaPrzyciskowStritow.get(1), gc);
		final Strit zeroJedenDwa = new Strit(0, 1, 2);
		tablicaStritow.add(zeroJedenDwa);
		
		gc.gridx = 2;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(2), gc);
		final Split zeroJeden = new Split(0, 1);
		tablicaSplitow.add(zeroJeden);
		
		gc.gridheight = 2;
		gc.gridx = 2;
		gc.gridy = 10;
		add(tablicaPrzyciskowKornerow.get(0), gc);
		final Korner pierwszeCztery = new Korner(0, 1, 2, 3);
		tablicaKornerow.add(pierwszeCztery);

		// trzecia kolumna

		gc.gridheight = 3;
		gc.gridx = 4;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(3), gc);
		final Numer trzy = new Numer(3);
		tablicaNumerow.add(trzy);
		
		gc.gridx = 4;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(3), gc);
		final Split dwaTrzy = new Split(2, 3);
		tablicaSplitow.add(dwaTrzy);

		gc.gridx = 4;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(2), gc);
		final Numer dwa = new Numer(2);
		tablicaNumerow.add(dwa);
		
		gc.gridx = 4;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(4), gc);
		final Split jedenDwa = new Split(1, 2);
		tablicaSplitow.add(jedenDwa);

		gc.gridx = 4;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(1), gc);
		final Numer jeden = new Numer(1);
		tablicaNumerow.add(jeden);
		
		gc.gridheight = 2;
		gc.gridx = 4;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(2), gc);
		final Strit jedenTrzy = new Strit(1, 2, 3);
		tablicaStritow.add(jedenTrzy);

		// czwarta kolumna

		gc.gridheight = 3;
		gc.gridx = 6;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(5), gc);
		final Split trzySzesc = new Split(3, 6);
		tablicaSplitow.add(trzySzesc);
		
		gc.gridx = 6;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(1), gc);
		final Korner dwaSzesc = new Korner(2, 3, 5, 6);
		tablicaKornerow.add(dwaSzesc);
		

		gc.gridx = 6;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(6), gc);
		final Split dwaPiec = new Split(2, 5);
		tablicaSplitow.add(dwaPiec);
		
		gc.gridx = 6;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(2), gc);
		final Korner jedenPiec = new Korner(1, 2, 4, 5);
		tablicaKornerow.add(jedenPiec);
		
		gc.gridx = 6;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(7), gc);
		final Split jedenCztery = new Split(1, 4);
		tablicaSplitow.add(jedenCztery);
		
		gc.gridheight = 2;
		gc.gridx = 6;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(0), gc);
		final SixLine jedenSzesc = new SixLine(1, 2, 3, 4, 5, 6);
		tablicaSixLinow.add(jedenSzesc);
		
		// pi¹ta kolumna

		gc.gridheight = 3;
		gc.gridx = 8;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(6), gc);
		final Numer szesc = new Numer(6);
		tablicaNumerow.add(szesc);

		gc.gridx = 8;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(8), gc);
		final Split piecSzesc = new Split(5, 6);
		tablicaSplitow.add(piecSzesc);
		
		gc.gridx = 8;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(5), gc);
		final Numer piec = new Numer(5);
		tablicaNumerow.add(piec);
		
		gc.gridx = 8;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(9), gc);
		final Split czteryPiec = new Split(4, 5);
		tablicaSplitow.add(czteryPiec);
		
		gc.gridx = 8;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(4), gc);
		final Numer cztery = new Numer(4);
		tablicaNumerow.add(cztery);
		
		gc.gridheight = 2;
		gc.gridx = 8;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(3), gc);
		final Strit czterySzesc = new Strit(4, 5, 6);
		tablicaStritow.add(czterySzesc);
		
		// szósta kolumna

		gc.gridheight = 3;
		gc.gridx = 10;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(10), gc);
		final Split szescDziewiec = new Split(6, 9);
		tablicaSplitow.add(szescDziewiec);
		
		gc.gridx = 10;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(3), gc);
		final Korner piecDziewiec = new Korner(5, 6, 8, 9);
		tablicaKornerow.add(piecDziewiec);
		
		gc.gridx = 10;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(11), gc);
		final Split piecOsiem = new Split(5, 8);
		tablicaSplitow.add(piecOsiem);
		
		gc.gridx = 10;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(4), gc);
		final Korner czteryOsiem = new Korner(4, 5, 7, 8);
		tablicaKornerow.add(czteryOsiem);
		
		gc.gridx = 10;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(12), gc);
		final Split czterySiedem = new Split(4, 7);
		tablicaSplitow.add(czterySiedem);
		
		gc.gridheight = 2;
		gc.gridx = 10;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(1), gc);
		final SixLine czteryDziewiec = new SixLine(4, 5, 6, 7, 8, 9);
		tablicaSixLinow.add(czteryDziewiec);
				
		// siódma kolumna
		gc.gridheight = 3;
		gc.gridx = 12;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(9), gc);
		final Numer dziewiec = new Numer(9);
		tablicaNumerow.add(dziewiec);
		
		gc.gridx = 12;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(13), gc);
		final Split osiemDziewiec = new Split(8, 9);
		tablicaSplitow.add(osiemDziewiec);
		
		gc.gridx = 12;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(8), gc);
		final Numer osiem = new Numer(8);
		tablicaNumerow.add(osiem);
		
		gc.gridx = 12;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(14), gc);
		final Split siedemOsiem = new Split(7, 8);
		tablicaSplitow.add(siedemOsiem);
		
		gc.gridx = 12;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(7), gc);
		final Numer siedem = new Numer(7);
		tablicaNumerow.add(siedem);
		
		gc.gridheight = 2;
		gc.gridx = 12;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(4), gc);
		final Strit siedemDziewiec = new Strit(7, 8, 9);
		tablicaStritow.add(siedemDziewiec);
		
		// ósma kolumna

		gc.gridheight = 3;
		gc.gridx = 14;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(15), gc);
		final Split dziewiecDwanascie = new Split(9,13);
		tablicaSplitow.add(dziewiecDwanascie);
		
		gc.gridx = 14;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(5), gc);
		final Korner osiemDwanascie = new Korner(8,9,11,12);
		tablicaKornerow.add(osiemDwanascie);
		
		gc.gridx = 14;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(16), gc);
		final Split osiemJedenascie = new Split(8,11);
		tablicaSplitow.add(osiemJedenascie);

		gc.gridx = 14;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(6), gc);
		final Korner siedemJedenascie = new Korner(7,8,10,11);
		tablicaKornerow.add(siedemJedenascie);
		
		gc.gridx = 14;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(17), gc);
		final Split siedemDziesiec = new Split(7,10);
		tablicaSplitow.add(siedemDziesiec);
		
		gc.gridheight = 2;
		gc.gridx = 14;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(2), gc);
		final SixLine siedemDwanascie = new SixLine(7,8,9,10,11,12);
		tablicaSixLinow.add(siedemDwanascie);
		
		// dziewi¹ta kolumna
		gc.gridheight = 3;
		gc.gridx = 16;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(12), gc);
		final Numer dwanascie = new Numer(12);
		tablicaNumerow.add(dwanascie);

		gc.gridx = 16;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(18), gc);
		final Split jedenascieDwanascie = new Split(11,12);
		tablicaSplitow.add(jedenascieDwanascie);
		
		gc.gridx = 16;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(11), gc);
		final Numer jedenascie = new Numer(11);
		tablicaNumerow.add(jedenascie);
		

		gc.gridx = 16;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(19), gc);
		final Split dziesiecJedenascie = new Split(10,11);
		tablicaSplitow.add(dziesiecJedenascie);
		
		gc.gridx = 16;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(10), gc);
		final Numer dziesiec = new Numer(10);
		tablicaNumerow.add(dziesiec);
		
		gc.gridheight = 2;
		gc.gridx = 16;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(5), gc);
		final Strit dziesiecDwanascie = new Strit(10,11,12);
		tablicaStritow.add(dziesiecDwanascie);
		
		// dziesi¹ta kolumna
		gc.gridheight = 3;
		gc.gridx = 18;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(20), gc);
		final Split dwanasciePietnascie = new Split(12,15);
		tablicaSplitow.add(dwanasciePietnascie);
		
		gc.gridx = 18;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(7), gc);
		final Korner jedenasciePietnascie = new Korner(11,12,14,15);
		tablicaKornerow.add(jedenasciePietnascie);
		
		gc.gridx = 18;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(21), gc);
		final Split jedenascieCzternascie = new Split(11,14);
		tablicaSplitow.add(jedenascieCzternascie);
		
		gc.gridx = 18;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(8), gc);
		final Korner dziesiecCzternascie = new Korner(10,11,13,14);
		tablicaKornerow.add(dziesiecCzternascie);
		
		gc.gridx = 18;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(22), gc);
		final Split dziesiecTrzynascie = new Split(10,13);
		tablicaSplitow.add(dziesiecTrzynascie);
		
		gc.gridheight = 2;
		gc.gridx = 18;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(3), gc);
		final SixLine dziesiecPietnascie = new SixLine(10,11,12,13,14,15);
		tablicaSixLinow.add(dziesiecPietnascie);
		
		// jedenasta kolumna

		gc.gridheight = 3;
		gc.gridx = 20;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(15), gc);
		final Numer pietnascie = new Numer(15);
		tablicaNumerow.add(pietnascie);
		
		gc.gridx = 20;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(23), gc);
		final Split czternasciePietnascie = new Split(14,15);
		tablicaSplitow.add(czternasciePietnascie);
		
		gc.gridx = 20;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(14), gc);
		final Numer czternascie = new Numer(14);
		tablicaNumerow.add(czternascie);
		
		gc.gridx = 20;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(24), gc);
		final Split trzynascieCzternascie = new Split(13,14);
		tablicaSplitow.add(trzynascieCzternascie);
		
		gc.gridx = 20;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(13), gc);
		final Numer trzynascie = new Numer(13);
		tablicaNumerow.add(trzynascie);
		
		gc.gridheight = 2;
		gc.gridx = 20;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(6), gc);
		final Strit trzynasciePietnascie = new Strit(13,14,15);
		tablicaStritow.add(trzynasciePietnascie);
		
		// dziesi¹ta kolumna
		gc.gridheight = 3;
		gc.gridx = 22;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(25), gc);
		final Split pietnascieOsiemnascie = new Split(15,18);
		tablicaSplitow.add(pietnascieOsiemnascie);
		
		gc.gridx = 22;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(9), gc);
		final Korner czternascieOsiemnascie = new Korner(14,15,17,18);
		tablicaKornerow.add(czternascieOsiemnascie);
		
		gc.gridx = 22;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(26), gc);
		final Split czternascieSiedemnascie = new Split(14,17);
		tablicaSplitow.add(czternascieSiedemnascie);
		
		gc.gridx = 22;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(10), gc);
		final Korner trzynascieSiedemnascie = new Korner(13,14,16,17);
		tablicaKornerow.add(trzynascieSiedemnascie);
		
		gc.gridx = 22;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(27), gc);
		final Split trzynascieSzesnascie = new Split(13,16);
		tablicaSplitow.add(trzynascieSzesnascie);
		
		gc.gridheight = 2;
		gc.gridx = 22;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(4), gc);
		final SixLine trzynascieOsiemnascie = new SixLine(13,14,15,15,17,18);
		tablicaSixLinow.add(trzynascieOsiemnascie);
		
		// trzynasta kolumna

		gc.gridheight = 3;
		gc.gridx = 24;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(18), gc);
		final Numer osiemnascie = new Numer(18);
		tablicaNumerow.add(osiemnascie);

		gc.gridx = 24;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(28), gc);
		final Split siedemnascieOsiemnascie = new Split(17,18);
		tablicaSplitow.add(siedemnascieOsiemnascie);
		
		gc.gridx = 24;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(17), gc);
		final Numer siedemnascie = new Numer(17);
		tablicaNumerow.add(siedemnascie);
		
		gc.gridx = 24;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(29), gc);
		final Split szesnascieSiedemnascie = new Split(16,17);
		tablicaSplitow.add(szesnascieSiedemnascie);

		gc.gridx = 24;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(16), gc);
		final Numer szesnascie = new Numer(16);
		tablicaNumerow.add(szesnascie);
		
		gc.gridheight = 2;
		gc.gridx = 24;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(7), gc);
		final Strit szesnascieOsiemnascie = new Strit(16,17,18);
		tablicaStritow.add(szesnascieOsiemnascie);

		// czternasta kolumna
		gc.gridheight = 3;
		gc.gridx = 26;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(30), gc);
		final Split osiemnascieDwadziesciajeden = new Split(18,21);
		tablicaSplitow.add(osiemnascieDwadziesciajeden);

		gc.gridx = 26;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(11), gc);
		final Korner siedemnascieDwadziesciajeden = new Korner(17,18,20,21);
		tablicaKornerow.add(siedemnascieDwadziesciajeden);

		gc.gridx = 26;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(31), gc);
		final Split siedemnascieDwadziescia = new Split(17,20);
		tablicaSplitow.add(siedemnascieDwadziescia);

		gc.gridx = 26;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(12), gc);
		final Korner szesnascieDwadziescia = new Korner(16,17,19,20);
		tablicaKornerow.add(szesnascieDwadziescia);
		
		gc.gridx = 26;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(32), gc);	
		final Split szesnascieDziewietnascie = new Split(16,19);
		tablicaSplitow.add(szesnascieDziewietnascie);

		gc.gridheight = 2;
		gc.gridx = 26;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(5), gc);
		final SixLine szesnascieDwadziesciajeden = new SixLine(16,17,18,19,20,21);
		tablicaSixLinow.add(szesnascieDwadziesciajeden);
		
		// piêtnasta kolumna

		gc.gridheight = 3;
		gc.gridx = 28;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(21), gc);
		final Numer dwadziesciajeden = new Numer(21);
		tablicaNumerow.add(dwadziesciajeden);

		gc.gridx = 28;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(33), gc);
		final Split dwadziesciaDwadziesciajeden = new Split(20,21);
		tablicaSplitow.add(dwadziesciaDwadziesciajeden);

		gc.gridx = 28;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(20), gc);
		final Numer dwadziescia = new Numer(20);
		tablicaNumerow.add(dwadziescia);
		
		gc.gridx = 28;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(34), gc);
		final Split dziewietnascieDwadziescia = new Split(19,20);
		tablicaSplitow.add(dziewietnascieDwadziescia);
		
		gc.gridx = 28;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(19), gc);
		final Numer dziewietnascie = new Numer(19);
		tablicaNumerow.add(dziewietnascie);
		
		gc.gridheight = 2;
		gc.gridx = 28;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(8), gc);
		final Strit dziewietnascieDwadziesciajeden = new Strit(19,20,21);
		tablicaStritow.add(dziewietnascieDwadziesciajeden);
		
		// szesnasta kolumna
		gc.gridheight = 3;
		gc.gridx = 30;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(35), gc);
		final Split dwadziesciajedenDwadziesciacztery = new Split(21,24);
		tablicaSplitow.add(dwadziesciajedenDwadziesciacztery);

		gc.gridx = 30;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(13), gc);
		final Korner dwadziesciaDwadziesciacztery = new Korner(20,21,23,24);
		tablicaKornerow.add(dwadziesciaDwadziesciacztery);
		
		gc.gridx = 30;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(36), gc);
		final Split dwadziesciaDwadziesciatrzy = new Split(20,23);
		tablicaSplitow.add(dwadziesciaDwadziesciatrzy);
		
		gc.gridx = 30;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(14), gc);
		final Korner dziewietnascieDwadziesciatrzy = new Korner(19,20,22,23);
		tablicaKornerow.add(dziewietnascieDwadziesciatrzy);
		
		gc.gridx = 30;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(37), gc);
		final Split dziewietnascieDwadziesciadwa = new Split(19,22);
		tablicaSplitow.add(dziewietnascieDwadziesciadwa);
		
		gc.gridheight = 2;
		gc.gridx = 30;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(6), gc);
		final SixLine dziewietnascieDwadziesciacztery = new SixLine(19,20,21,22,23,24);
		tablicaSixLinow.add(dziewietnascieDwadziesciacztery);
		
		// siedemnasta kolumna

		gc.gridheight = 3;
		gc.gridx = 32;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(24), gc);
		final Numer dwadziesciacztery = new Numer(24);
		tablicaNumerow.add(dwadziesciacztery);
		
		gc.gridx = 32;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(38), gc);
		final Split dwadziesciatrzyDwadziesciacztery = new Split(23,24);
		tablicaSplitow.add(dwadziesciatrzyDwadziesciacztery);
		
		gc.gridx = 32;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(23), gc);
		final Numer dwadziesciatrzy = new Numer(23);
		tablicaNumerow.add(dwadziesciatrzy);
		
		gc.gridx = 32;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(39), gc);
		final Split dwadziesciadwaDwadziesciatrzy = new Split(22,23);
		tablicaSplitow.add(dwadziesciadwaDwadziesciatrzy);
		
		gc.gridx = 32;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(22), gc);
		final Numer dwadziesciadwa = new Numer(22);
		tablicaNumerow.add(dwadziesciadwa);
		
		gc.gridheight = 2;
		gc.gridx = 32;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(9), gc);
		final Strit dwadziesciadwaDwadziesciacztery = new Strit(22,23,24);
		tablicaStritow.add(dwadziesciadwaDwadziesciacztery);
		
		// osiemnasta kolumna
		gc.gridheight = 3;
		gc.gridx = 34;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(40), gc);
		final Split dwadziesciaczteryDwadziesciasiedem = new Split(24,27);
		tablicaSplitow.add(dwadziesciaczteryDwadziesciasiedem);

		gc.gridx = 34;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(15), gc);
		final Korner dwadziesciatrzyDwadziesciasiedem = new Korner(23,24,26,27);
		tablicaKornerow.add(dwadziesciatrzyDwadziesciasiedem);

		gc.gridx = 34;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(41), gc);
		final Split dwadziesciatrzyDwadziesciaszesc = new Split(23,26);
		tablicaSplitow.add(dwadziesciatrzyDwadziesciaszesc);

		gc.gridx = 34;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(16), gc);
		final Korner dwadziesciadwaDwadziesciaszesc = new Korner(22,23,25,26);
		tablicaKornerow.add(dwadziesciadwaDwadziesciaszesc);
		
		gc.gridx = 34;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(42), gc);
		final Split dwadziesciadwaDwadziesciapiec = new Split(22,25);
		tablicaSplitow.add(dwadziesciadwaDwadziesciapiec);
		
		gc.gridheight = 2;
		gc.gridx = 34;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(7), gc);
		final SixLine dwadziesciadwaDwadziesciasiedem = new SixLine(22,23,24,25,26,27);
		tablicaSixLinow.add(dwadziesciadwaDwadziesciasiedem);
		
		// dziewiêtnasta kolumna

		gc.gridheight = 3;
		gc.gridx = 36;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(27), gc);
		final Numer dwadziesciasiedem = new Numer(27);
		tablicaNumerow.add(dwadziesciasiedem);

		gc.gridx = 36;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(43), gc);
		final Split dwadziesciaszescDwadziesciasiedem = new Split(26,27);
		tablicaSplitow.add(dwadziesciaszescDwadziesciasiedem);
		
		gc.gridx = 36;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(26), gc);
		final Numer dwadziesciaszesc = new Numer(26);
		tablicaNumerow.add(dwadziesciaszesc);
		
		gc.gridx = 36;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(44), gc);
		final Split dwadziesciapiecDwadziesciaszesc = new Split(25,26);
		tablicaSplitow.add(dwadziesciapiecDwadziesciaszesc);
		
		gc.gridx = 36;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(25), gc);
		final Numer dwadziesciapiec = new Numer(25);
		tablicaNumerow.add(dwadziesciapiec);
		
		gc.gridheight = 2;
		gc.gridx = 36;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(10), gc);
		final Strit dwadziesciapiecDwadziesciasiedem = new Strit(25,26,27);
		tablicaStritow.add(dwadziesciapiecDwadziesciasiedem);
		
		// dwudziesta kolumna

		gc.gridheight = 3;
		gc.gridx = 38;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(45), gc);
		final Split dwadziesciasiedemTrzydziesci = new Split(27,30);
		tablicaSplitow.add(dwadziesciasiedemTrzydziesci);
		
		gc.gridx = 38;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(17), gc);
		final Korner dwadziesciaszescTrzydziesci = new Korner(26,27,29,30);
		tablicaKornerow.add(dwadziesciaszescTrzydziesci);
		
		gc.gridx = 38;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(46), gc);
		final Split dwadziesciaszescDwadziesciadziewiec = new Split(26,29);
		tablicaSplitow.add(dwadziesciaszescDwadziesciadziewiec);
		
		gc.gridx = 38;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(18), gc);
		final Korner dwadziesciapiecDwadziesciadziewiec = new Korner(25,26,28,29);
		tablicaKornerow.add(dwadziesciapiecDwadziesciadziewiec);

		gc.gridx = 38;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(47), gc);
		final Split dwadziesciapiecDwadziesciaosiem = new Split(25,28);
		tablicaSplitow.add(dwadziesciapiecDwadziesciaosiem);
		
		gc.gridheight = 2;
		gc.gridx = 38;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(8), gc);
		final SixLine dwadziesciapiecTrzydziesci = new SixLine(25,26,27,28,29,30);
		tablicaSixLinow.add(dwadziesciapiecTrzydziesci);

		// dwudziesta pierwsza kolumna

		gc.gridheight = 3;
		gc.gridx = 40;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(30), gc);
		final Numer trzydziesci = new Numer(30);
		tablicaNumerow.add(trzydziesci);
	 
		gc.gridx = 40;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(48), gc);
		final Split dwadziesciadziewiecTrzydziesci = new Split(29,30);
		tablicaSplitow.add(dwadziesciadziewiecTrzydziesci);
		
		gc.gridx = 40;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(29), gc);
		final Numer dwadziesciadziewiec = new Numer(29);
		tablicaNumerow.add(dwadziesciadziewiec);
		
		gc.gridx = 40;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(49), gc);
		final Split dwadziesciaosiemDwadziesciadziewiec = new Split(28,29);
		tablicaSplitow.add(dwadziesciaosiemDwadziesciadziewiec);
		
		gc.gridx = 40;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(28), gc);
		final Numer dwadziesciaosiem = new Numer(28);
		tablicaNumerow.add(dwadziesciaosiem);
		
		gc.gridheight = 2;
		gc.gridx = 40;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(11), gc);
		final Strit dwadziesciaosiemTrzydziesci = new Strit(28,29,30);
		tablicaStritow.add(dwadziesciaosiemTrzydziesci);

		// dwudziesta druga kolumna

		gc.gridheight = 3;
		gc.gridx = 42;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(50), gc);
		final Split trzydziesciTrzydziescitrzy = new Split(30,33);
		tablicaSplitow.add(trzydziesciTrzydziescitrzy);

		gc.gridx = 42;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(19), gc);
		final Korner dwadziesciadziewiecTrzydziescitrzy = new Korner(29,30,32,33);
		tablicaKornerow.add(dwadziesciadziewiecTrzydziescitrzy);
		
		gc.gridx = 42;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(51), gc);
		final Split dwadziesciadziewiecTrzydziescidwa = new Split(29,32);
		tablicaSplitow.add(dwadziesciadziewiecTrzydziescidwa);
		
		gc.gridx = 42;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(20), gc);
		final Korner dwadziesciaosiemTrzydziescidwa = new Korner(28,29,31,32);
		tablicaKornerow.add(dwadziesciaosiemTrzydziescidwa);

		gc.gridx = 42;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(52), gc);
		final Split dwadziesciaosiemTrzydziescijeden = new Split(28,31);
		tablicaSplitow.add(dwadziesciaosiemTrzydziescijeden);

		gc.gridheight = 2;
		gc.gridx = 42;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(9), gc);
		final SixLine dwadziesciaosiemTrzydziescitrzy = new SixLine(28,29,30,31,32,33);
		tablicaSixLinow.add(dwadziesciaosiemTrzydziescitrzy);
		
		// dwudziesta trzecia kolumna

		gc.gridheight = 3;
		gc.gridx = 44;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(33), gc);
		final Numer trzydziescitrzy = new Numer(33);
		tablicaNumerow.add(trzydziescitrzy);
		
		gc.gridx = 44;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(53), gc);
		final Split trzydziescidwaTrzydziescitrzy = new Split(32,33);
		tablicaSplitow.add(trzydziescidwaTrzydziescitrzy);
		
		gc.gridx = 44;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(32), gc);
		final Numer trzydziescidwa = new Numer(32);
		tablicaNumerow.add(trzydziescidwa);
		
		gc.gridx = 44;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(54), gc);
		final Split trzydziescijedenTrzydziescidwa = new Split(31,32);
		tablicaSplitow.add(trzydziescijedenTrzydziescidwa);
		
		gc.gridx = 44;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(31), gc);
		final Numer trzydziescijeden = new Numer(31);
		tablicaNumerow.add(trzydziescijeden);
		
		gc.gridheight = 2;
		gc.gridx = 44;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(12), gc);
		final Strit trzydziescijedenTrzydziescitrzy = new Strit(31,32,33);
		tablicaStritow.add(trzydziescijedenTrzydziescitrzy);
		
		// dwudziesta czwarta kolumna

		gc.gridheight = 3;
		gc.gridx = 46;
		gc.gridy = 0;
		add(tablicaPrzyciskowSplitow.get(55), gc);
		final Split trzydziescitrzyTrzydziesciszesc = new Split(33,36);
		tablicaSplitow.add(trzydziescitrzyTrzydziesciszesc);
		
		gc.gridx = 46;
		gc.gridy = 2;
		add(tablicaPrzyciskowKornerow.get(21), gc);
		final Korner trzydziescidwaTrzydziesciszesc = new Korner(32,33,35,36);
		tablicaKornerow.add(trzydziescidwaTrzydziesciszesc);
		
		gc.gridx = 46;
		gc.gridy = 4;
		add(tablicaPrzyciskowSplitow.get(56), gc);
		final Split trzydziescidwaTrzydziescipiec = new Split(32,35);
		tablicaSplitow.add(trzydziescidwaTrzydziescipiec);
		
		gc.gridx = 46;
		gc.gridy = 6;
		add(tablicaPrzyciskowKornerow.get(22), gc);
		final Korner trzydziescijedenTrzydziescipiec = new Korner(31,32,34,35);
		tablicaKornerow.add(trzydziescijedenTrzydziescipiec);
		
		gc.gridx = 46;
		gc.gridy = 8;
		add(tablicaPrzyciskowSplitow.get(57), gc);
		final Split trzydziescijedenTrzydziescicztery = new Split(31,34);
		tablicaSplitow.add(trzydziescijedenTrzydziescicztery);
		
		gc.gridheight = 2;
		gc.gridx = 46;
		gc.gridy = 10;
		add(tablicaPrzyciskowSixLinow.get(10), gc);
		final SixLine trzydziescijedenTrzydziesciszesc = new SixLine(31,32,33,34,35,36);
		tablicaSixLinow.add(trzydziescijedenTrzydziesciszesc);
		
		// dwudziesta pi¹ta kolumna
		gc.gridheight = 3;
		gc.gridwidth = 4;
		gc.gridx = 48;
		gc.gridy = 0;
		add(tablicaPrzyciskowNumerow.get(36), gc);
		final Numer trzydziesciszesc = new Numer(36);
		tablicaNumerow.add(trzydziesciszesc);

		gc.gridx = 48;
		gc.gridy = 2;
		add(tablicaPrzyciskowSplitow.get(58), gc);
		final Split trzydziescipiecTrzydziesciszesc = new Split(35,36);
		tablicaSplitow.add(trzydziescipiecTrzydziesciszesc);
		
		gc.gridx = 48;
		gc.gridy = 4;
		add(tablicaPrzyciskowNumerow.get(35), gc);
		final Numer trzydziescipiec = new Numer(35);
		tablicaNumerow.add(trzydziescipiec);
		
		gc.gridx = 48;
		gc.gridy = 6;
		add(tablicaPrzyciskowSplitow.get(59), gc);
		final Split trzydziesciczteryTrzydziescipiec = new Split(34,35);
		tablicaSplitow.add(trzydziesciczteryTrzydziescipiec);
		
		gc.gridx = 48;
		gc.gridy = 8;
		add(tablicaPrzyciskowNumerow.get(34), gc);
		final Numer trzydziescicztery = new Numer(34);
		tablicaNumerow.add(trzydziescicztery);
		
		gc.gridheight = 2;
		gc.gridx = 48;
		gc.gridy = 10;
		add(tablicaPrzyciskowStritow.get(13), gc);
		final Strit trzydziesciczteryTrzydziesciszesc = new Strit(34,35,36);
		tablicaStritow.add(trzydziesciczteryTrzydziesciszesc);
		
		// kolumna z kolumnami

		gc.gridwidth = 3;
		gc.gridheight = 3;
		gc.gridx = 52;
		gc.gridy = 0;
		add(tablicaPrzyciskowKolumnITuzinow.get(0), gc);
		KolumnaITuzin trzeciaKolumna = new KolumnaITuzin(0);
		tablicaKolumnITuzinow.add(trzeciaKolumna);

		gc.gridx = 52;
		gc.gridy = 4;
		add(tablicaPrzyciskowKolumnITuzinow.get(1), gc);	
		KolumnaITuzin drugaKolumna = new KolumnaITuzin(1);
		tablicaKolumnITuzinow.add(drugaKolumna);

		
		gc.gridx = 52;
		gc.gridy = 8;
		add(tablicaPrzyciskowKolumnITuzinow.get(2), gc);
		KolumnaITuzin pierwszaKolumna = new KolumnaITuzin(0);
		tablicaKolumnITuzinow.add(pierwszaKolumna);

		// tuziny

		gc.gridwidth = 15;
		gc.gridheight = 2;
		gc.gridx = 4;
		gc.gridy = 11;
		add(tablicaPrzyciskowKolumnITuzinow.get(3), gc);
		KolumnaITuzin pierwszyTuzin = new KolumnaITuzin(3);
		tablicaKolumnITuzinow.add(pierwszyTuzin);


		gc.gridx = 20;
		gc.gridy = 11;
		add(tablicaPrzyciskowKolumnITuzinow.get(4), gc);
		KolumnaITuzin drugiTuzin = new KolumnaITuzin(4);
		tablicaKolumnITuzinow.add(drugiTuzin);
		
		gc.gridx = 36;
		gc.gridy = 11;
		add(tablicaPrzyciskowKolumnITuzinow.get(5), gc);
		KolumnaITuzin trzeciTuzin = new KolumnaITuzin(5);
		tablicaKolumnITuzinow.add(trzeciTuzin);
		
		// szanse proste

		gc.gridheight = 5;
		gc.gridwidth = 7;
		gc.gridx = 4;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(0), gc);
		Niskie niskie = new Niskie(0);
		tablicaSzansProstych.add(niskie);

		gc.gridx = 12;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(1), gc);
		Parzyste parzyste = new Parzyste(1);
		tablicaSzansProstych.add(parzyste);
		
		gc.gridx = 20;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(2), gc);
		Czerwone czerwone = new Czerwone(2);
		tablicaSzansProstych.add(czerwone);
		
		gc.gridx = 28;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(3), gc);
		Czarne czarne = new Czarne(3);
		tablicaSzansProstych.add(czarne);

		gc.gridx = 36;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(4), gc);
		Nieparzyste nieparzyste = new Nieparzyste(4);
		tablicaSzansProstych.add(nieparzyste);
		
		gc.gridx = 44;
		gc.gridy = 12;
		add(tablicaPrzyciskowSzansProstych.get(5), gc);
		Wysokie wysokie = new Wysokie(5);
		tablicaSzansProstych.add(wysokie);
		
		// utworzenie przycisku, który wyœwietla³ bêdzie ¿eton aktualnej stawki
		
		gc.gridwidth = 3;
		gc.gridheight = 5;
		gc.gridx = 52;
		gc.gridy = 12;
		add(przyciskAktualnejStawki, gc);

		// utworzenie cegie³ek tworz¹cy spójny dla u¿ytkownika widok
		gc.gridheight = 1;
		gc.gridwidth = 1;
		int u;
		for (u = 0; u < 15; u++) {

			BrickButton brick = new BrickButton(u);
			gc.gridx = 55;
			gc.gridy = u;
			add(brick, gc);

		}

		for (u = 0; u < 56; u++) {
			BrickButton brick = new BrickButton(u + 100);
			gc.gridx = u;
			gc.gridy = 16;
			add(brick, gc);
		}
		
		//ustawienie domyœlnej wartosci jednego zetonu
		wartoscJednegoZetonu = 10;

	}

	public class NumerListener implements ActionListener {
		int numerek;

		public NumerListener(int d) {
			numerek = d;
		}

		public void actionPerformed(ActionEvent ev) {
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
				
			
				Numer obecny = tablicaNumerow.get(numerek);
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowNumerow.get(numerek);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;				
				if((kwotaZakladu >= 10) & (kwotaZakladu <= 500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu > 500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
			}
		}
	}
	
	public class SplitListener implements ActionListener {
		int numerekSplitow;
		
		public SplitListener(int d){
			numerekSplitow = d;
			
		}
		
		public void actionPerformed (ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
				
				Split obecny = tablicaSplitow.get(numerekSplitow);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowSplitow.get(numerekSplitow);
				if((kwotaZakladu >= 10) & (kwotaZakladu <= 500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu > 500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
			}
		}
		
	}

	public class KornerListener implements ActionListener {
		int numerekKornerow;
		
		public KornerListener(int d){
			numerekKornerow = d;
			
		}
		
		public void actionPerformed (ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
					
				Korner obecny = tablicaKornerow.get(numerekKornerow);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowKornerow.get(numerekKornerow);
				if((kwotaZakladu >= 10) & (kwotaZakladu <= 500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu > 500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
			}
		}
		
	}
	
	public class StritListener implements ActionListener {
		int numerekStritow;
		
		public StritListener(int d){
			numerekStritow = d;
			
		}
		
		public void actionPerformed(ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
					
				Strit obecny = tablicaStritow.get(numerekStritow);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowStritow.get(numerekStritow);
				if((kwotaZakladu >= 10) & (kwotaZakladu <= 500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu > 500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}

			}
		}
	}
	
	public class SixLineListener implements ActionListener{
		int numerekSixLinow;
		
		public SixLineListener(int d){
			numerekSixLinow = d;
			
		}
		
		public void actionPerformed(ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
			
				SixLine obecny = tablicaSixLinow.get(numerekSixLinow);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowSixLinow.get(numerekSixLinow);
				if((kwotaZakladu >= 10) & (kwotaZakladu <= 500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu > 500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
			}
		}
		
	}
	
	public class KolumnaITuzinListener implements ActionListener {
		int numerekKolumnaITuzin;
		
		public KolumnaITuzinListener(int d){
			numerekKolumnaITuzin = d;
			
		}
		
		public void actionPerformed(ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
		
				KolumnaITuzin obecny = tablicaKolumnITuzinow.get(numerekKolumnaITuzin);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowKolumnITuzinow.get(numerekKolumnaITuzin);
				if((kwotaZakladu >= 50) & (kwotaZakladu <= 1500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu < 50){
					firePonizejMinimumEvent(new PonizejMinimumEvent(this));
				}if(kwotaZakladu > 1500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
			}
		}
		
	}
	
	public class SzanseProsteListener implements ActionListener {
		int numerekSzansProstych;
		
		public SzanseProsteListener(int d){
			numerekSzansProstych = d;
			
		}
		
		public void actionPerformed(ActionEvent ev){
			sprawdzSaldo(new SprawdzSaldoEvent(this, wartoscJednegoZetonu));
			if(saSrodki == true){
				
				SzansaProsta obecny = tablicaSzansProstych.get(numerekSzansProstych);
				PrzyciskDlaRuletki wlasciwy = tablicaPrzyciskowSzansProstych.get(numerekSzansProstych);
				int kwotaZakladu = obecny.getKwotaZakladu() + wartoscJednegoZetonu;
				if((kwotaZakladu >= 50) & (kwotaZakladu <= 1500)){
					obecny.setWielkoscObstawienia(wartoscJednegoZetonu);
					dokonanoObstawienia(new DokonanoObstawieniaEvent(this, wartoscJednegoZetonu, obecny, wlasciwy));
					wlasciwy.ustawIkone(kwotaZakladu);
				}if(kwotaZakladu < 50){
					firePonizejMinimumEvent(new PonizejMinimumEvent(this));
				}if(kwotaZakladu > 1500){
					firePowyzejMaksimumEvent(new PowyzejMaksimumEvent(this));
				}
				
			}
		}
		
	}

	public void setWartoscJednegoZetonu(int wartosc){
		wartoscJednegoZetonu = wartosc;
	}
	

	public void addDokonanoObstawieniaListener(DokonanoObstawieniaListener listener){
		dokonanoObstawieniaListenerList.add(DokonanoObstawieniaListener.class, listener);
	}
	
	public void removeDokonanoObstawieniaListener(DokonanoObstawieniaListener listener){
		dokonanoObstawieniaListenerList.remove(DokonanoObstawieniaListener.class, listener);
	}
	

	public void addPowyzejMaksimumListener(PowyzejMaksimumListener listener){
		powyzejMaksimumListenerList.add(PowyzejMaksimumListener.class, listener);
	}
	
	public void removePowyzejMaksimumListener(PowyzejMaksimumListener listener){
		powyzejMaksimumListenerList.remove(PowyzejMaksimumListener.class, listener);
	}
	

	public void addPonizejMinimumListener(PonizejMinimumListener listener){
		ponizejMinimumListenerList.add(PonizejMinimumListener.class, listener);
	}
	
	public void removePonizejMinimumListener(PonizejMinimumListener listener){
		ponizejMinimumListenerList.remove(PonizejMinimumListener.class, listener);
	}
	
	public void addSprawdzSaldoListener(SprawdzSaldoListener listener){
		sprawdzSaldoListenerList.add(SprawdzSaldoListener.class, listener);
	}
	
	public void removeSprawdzSaldoListener(SprawdzSaldoListener listener){
		sprawdzSaldoListenerList.remove(SprawdzSaldoListener.class, listener);
	}
	
	public void setStanSrodkow(boolean stanSrodkow){
		saSrodki = stanSrodkow;	
	}
	
	
	public boolean getStanSrodkow(){
		return saSrodki;
	}
	
	
	public void sprawdzSaldo(SprawdzSaldoEvent event){
		
		Object[]listeners = sprawdzSaldoListenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2){
			if(listeners[i]==SprawdzSaldoListener.class){
				((SprawdzSaldoListener) listeners[i+1]).sprawdzSaldo(event);
			}
		}
		
		
	}
	
	public void firePonizejMinimumEvent(PonizejMinimumEvent event){
		Object[]listeners = ponizejMinimumListenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2){
			if(listeners[i]==PonizejMinimumListener.class){
				((PonizejMinimumListener) listeners[i+1]).firePonizejMinimumEvent(event);
			}
		}
		
		
	}
			
	public void firePowyzejMaksimumEvent(PowyzejMaksimumEvent event) {
		Object[]listeners = powyzejMaksimumListenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2){
			if(listeners[i]==PowyzejMaksimumListener.class){
				((PowyzejMaksimumListener) listeners[i+1]).firePowyzejMaksimumEvent(event);
			}
		}
	
		
		
	}

	public void dokonanoObstawienia(DokonanoObstawieniaEvent event){
		Object[]listeners = dokonanoObstawieniaListenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2){
			if(listeners[i]==DokonanoObstawieniaListener.class){
				((DokonanoObstawieniaListener) listeners[i+1]).dokonanoObstawienia(event);
			}
		}
	
		
		
	}
		

	
	
}

