package com.blinddealercasino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;

/** 
 * G³ówne okno aplikacji widoczne dla gracza. Wiêkszoœæ kluczowych dzia³añ aplikacji 
 * odbywa siê w³aœnie tutaj (klasa kontrolera pojawi siê w kolejnym moich projekcie, tutaj 
 * pozostawi³em pierwotne za³o¿enia). Odpowiada w g³ównej mierze za komunikacjê pomiêdzy poszczególnymi
 * czêœciami aplikacji(panelKontrolny--->MainFrame---->panelObstawien--->panelZNumeramiX i odwrotnie).
 * Za komunikacjê odpowiadaj¹ EventListenery podczepione pod powy¿ej wymienione panele. Ka¿dy z nich
 * przyjmuje jako argument okreœlony rodzaj zdarzenia.  
 * Znajduje siê tu te¿ metoda losuj¹ca wy³aniaj¹ca wygrany numer. 
 * 
 * Menu g³ówne aplikacji docelowo sk³adaæ siê bêdzie z wiêkszej iloœci opcji. 
 *
 * Ramka posiada sta³e rozmiary, których u¿ytkownik nie mo¿e zmieniaæ.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public class MainFrame extends JFrame {


	private static final long serialVersionUID = 8937302853654165972L;

	protected PanelObstawien panelObstawien;
	protected PanelKontrolny panelKontrolny;
	private int wygranyNumer;
	private int kwotaCalkowitejWygranej;
	private int trzeciaKolumna[] = {3,6,9,12,15,18,21,24,27,30,33,36};
	private int drugaKolumna [] = {2,5,8,11,14,17,20,23,26,29,32,35};
	private int pierwszaKolumna[] = {1,4,7,10,13,16,19,22,25,28,31,34};
	private int pierwszyTuzin[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	private int drugiTuzin[] = {13,14,15,16,17,18,19,20,21,22,23,24};
	private int trzeciTuzin[] = {25,26,27,28,29,30,31,32,33,34,35,36};
	private int niskie[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	private int parzyste[] = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
	private int czerwone[] = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
	private int czarne[] = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
	private int nieparzyste[] = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
	private int wysokie[] = {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
	private int wartoscObstawieniaNaRzut;
	private int wartoscOstatniegoObstawienia;
	private Zaklad ostatniZaklad;
	private PrzyciskDlaRuletki ostatniPrzycisk;
	private boolean flagaBlokadyObstawien;

	public MainFrame(String tytul) {

		// konstruktor nadklasy
		super(tytul);
		// layout manager
		addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int wartoscSalda = panelKontrolny.getWartoscSalda();
                SaveGame save = new SaveGame();
                save.zapiszGre(wartoscSalda);
            	e.getWindow().dispose();
            }
        });
	
	
		
		setLayout(new BorderLayout());
		setResizable(false);
		// stworzenie klasy odpowiadaj¹cej za dŸwiêk
		/*/Sound dzwiek = new Sound();
		try{
			
		
			Thread dzwiekowy = new Thread(dzwiek);		
			dzwiek.setGraMuzyka(true);
			dzwiekowy.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		/*/
		
		
		// tworzenie komponentów paneli g³ownych:
		panelObstawien = new PanelObstawien();
		panelKontrolny = new PanelKontrolny();
		
		
		
		// dodanie do paneluObstawien listenera sprawdzaj¹cego stan salda
		panelObstawien.panelZNumeramiX.addSprawdzSaldoListener(new SprawdzSaldoListener(){

			public void sprawdzSaldo(SprawdzSaldoEvent event) {
				int wartoscObstawienia = event.getWartoscObstawienia();	
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				if (flagaBlokadyObstawien == false){
					if (wartoscSalda>=wartoscObstawienia){
						panelObstawien.panelZNumeramiX.setStanSrodkow(true);
					}
					else{
						panelObstawien.panelZNumeramiX.setStanSrodkow(false);
						panelKontrolny.getMiejsceNaTekst().appendKomunikatBrakSrodkow();
				
					}
				}else {
					panelKontrolny.getMiejsceNaTekst().appendKomunikatBlokady();
					panelObstawien.panelZNumeramiX.setStanSrodkow(false);
				}
				
			}
			
		});

		
		// dodanie do paneluObstawien listenera potwierdzajacego dokonanie obstawienia
		panelObstawien.panelZNumeramiX.addDokonanoObstawieniaListener(new DokonanoObstawieniaListener(){

			public void dokonanoObstawienia(DokonanoObstawieniaEvent event) {
				wartoscOstatniegoObstawienia = event.getWartoscObstawienia();
				ostatniPrzycisk = event.getPrzycisk();
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				ostatniZaklad = event.getZaklad();
				wartoscObstawieniaNaRzut = wartoscObstawieniaNaRzut + wartoscOstatniegoObstawienia;
				wartoscSalda = wartoscSalda - wartoscOstatniegoObstawienia;
				panelKontrolny.setWartoscSalda(wartoscSalda);
				panelKontrolny.refreshSaldo();
				panelKontrolny.enableCofnij();
				panelKontrolny.enableWyczysc();
				
				
			}
			
		});
		
		//dodanie listenera do paneluZNumeramiX, który przechwyci zdarzenie obstawienia poni¿ej minimum(szanse)
		
		panelObstawien.panelZNumeramiX.addPonizejMinimumListener(new PonizejMinimumListener(){

			
			public void firePonizejMinimumEvent(PonizejMinimumEvent event) {
				panelKontrolny.getMiejsceNaTekst().appendPonizejMaksimum();;
				
			}
		
			
			
		});
		
		// dodanie listenera do paneluZNumeramiX, który przechwyci zdarzenie obstawienia powy¿ej minimum
		
		panelObstawien.panelZNumeramiX.addPowyzejMaksimumListener(new PowyzejMaksimumListener() {
			
		
			public void firePowyzejMaksimumEvent(PowyzejMaksimumEvent event) {
				panelKontrolny.getMiejsceNaTekst().appendPowyzejMaksimum();
				
			}
		});
		//dodanie listenera og³aszajacego nowe obstawienia
		
		panelKontrolny.addNoweObstawieniaListener(new NoweObstawieniaListener() {
			
			
			public void fireNoweObstawieniaEvent(NoweObstawieniaEvent event) {
				zerujPoprzedniaKwota();
				usuniecieStarychObstawien(false);
				panelKontrolny.disableNoweObstawienia();
				panelKontrolny.enableRebet();
				panelKontrolny.enableRebet2x();
				panelKontrolny.enableStart();
				wartoscObstawieniaNaRzut = 0;
				flagaBlokadyObstawien = false;
				
			}
		});
		
		
		
		//dodanie listenera do paneluKontrolnego informujacego, ¿e user chce cofn¹æ ostatnie obstawienie
		panelKontrolny.addCofnijKliknietoListener(new CofnijKliknietoListener(){

			public void cofnijKliknieto(CofnijKliknietoEvent event) {
				int wartoscDoCofniecia = 0-wartoscOstatniegoObstawienia;
				ostatniZaklad.setWielkoscObstawienia(wartoscDoCofniecia);
				ostatniPrzycisk.ustawIkone(ostatniZaklad.getKwotaZakladu());
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				wartoscSalda = wartoscSalda + wartoscOstatniegoObstawienia;
				wartoscObstawieniaNaRzut = wartoscObstawieniaNaRzut - wartoscOstatniegoObstawienia;
				panelKontrolny.setWartoscSalda(wartoscSalda);
				panelKontrolny.refreshSaldo();
				panelKontrolny.disableCofnij();
				if (wartoscObstawieniaNaRzut == 0){
					panelKontrolny.disableWyczysc();
				}
				
			}
			
			
		});
		
		//dodanie listenera do paneluKontrolnego informujacego, ¿e user chce ponowic stare obstawienia
		panelKontrolny.addRebetListener(new RebetListener() {
			
			
			public void fireRebetEvent(RebetEvent event) {
				int kwotaRebet = 0;
				
				//ponowne obstawienie numerów 
				for (int i = 0; i < 37; i++){
					
					Numer rebetNumerow = panelObstawien.panelZNumeramiX.tablicaNumerow.get(i);
					rebetNumerow.rebetKwotaZakladu(rebetNumerow.getPoprzedniaKwota());
					int kwotaObstawienia = rebetNumerow.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowNumerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(i);
					rebetPrzyciskowNumerow.ustawKwoteRebet(rebetNumerow.getPoprzedniaKwota());
					
				}
				
				//ponowne obstawienie splitów
				for(int i = 0; i < 60; i++){
					Split rebetSplitow = panelObstawien.panelZNumeramiX.tablicaSplitow.get(i);
					rebetSplitow.rebetKwotaZakladu(rebetSplitow.getPoprzedniaKwota());
					int kwotaObstawienia = rebetSplitow.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowSplitow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSplitow.get(i);
					rebetPrzyciskowSplitow.ustawKwoteRebet(rebetSplitow.getPoprzedniaKwota());
					
				}
				//ponowne obstawienie stritów
				for (int i = 0; i < 14; i++){
					Strit rebetStritow = panelObstawien.panelZNumeramiX.tablicaStritow.get(i);
					rebetStritow.rebetKwotaZakladu(rebetStritow.getPoprzedniaKwota());
					int kwotaObstawienia = rebetStritow.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowStritow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowStritow.get(i);
					rebetPrzyciskowStritow.ustawKwoteRebet(rebetStritow.getPoprzedniaKwota());
					
				}
				// ponowne obstawienie kornerów
				for (int i = 0; i < 23; i++){
					Korner rebetKornerow = panelObstawien.panelZNumeramiX.tablicaKornerow.get(i);
					rebetKornerow.rebetKwotaZakladu(rebetKornerow.getPoprzedniaKwota());
					int kwotaObstawienia = rebetKornerow.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowKornerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKornerow.get(i);
					rebetPrzyciskowKornerow.ustawKwoteRebet(rebetKornerow.getPoprzedniaKwota());					
				}

				//ponowne obstawienie sixlinów
				for (int i = 0; i < 11; i++){
					SixLine rebetSixLinow = panelObstawien.panelZNumeramiX.tablicaSixLinow.get(i);
					rebetSixLinow.rebetKwotaZakladu(rebetSixLinow.getPoprzedniaKwota());
					int kwotaObstawienia = rebetSixLinow.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowSixLinow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSixLinow.get(i);
					rebetPrzyciskowSixLinow.ustawKwoteRebet(rebetSixLinow.getPoprzedniaKwota());
				}
				
				//ponowne obstawienie kolumn i tuzinów
				for (int i = 0; i < 6; i++){
					KolumnaITuzin rebetKIT = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(i);
					rebetKIT.rebetKwotaZakladu(rebetKIT.getPoprzedniaKwota());
					int kwotaObstawienia = rebetKIT.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowKIT = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKolumnITuzinow.get(i);
					rebetPrzyciskowKIT.ustawKwoteRebet(rebetKIT.getPoprzedniaKwota());					
				}
				
				// ponowne obstawienie szans prostych
				for (int i = 0; i <6; i++){
					SzansaProsta rebetSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(i);				
					rebetSzansy.rebetKwotaZakladu(rebetSzansy.getPoprzedniaKwota());
					int kwotaObstawienia = rebetSzansy.getKwotaZakladu();
					kwotaRebet = kwotaRebet + kwotaObstawienia;
					PrzyciskDlaRuletki rebetPrzyciskowSzansy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(i);
					rebetPrzyciskowSzansy.ustawKwoteRebet(rebetSzansy.getPoprzedniaKwota());
					
				}	
				
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				if(wartoscSalda < kwotaRebet){
					usuniecieStarychObstawien(true);
					panelKontrolny.getMiejsceNaTekst().appendKomunikatBrakSrodkow();
				}if(wartoscSalda>=kwotaRebet) {
					wartoscSalda = wartoscSalda - kwotaRebet;
					panelKontrolny.setWartoscSalda(wartoscSalda);
					panelKontrolny.refreshSaldo();
					wartoscObstawieniaNaRzut = kwotaRebet; 
				}
				
				panelKontrolny.disableRebet();
				panelKontrolny.disableRebet2x();
				panelKontrolny.enableStart();
				panelKontrolny.disableCofnij();
				panelKontrolny.enableWyczysc();
			
				
			}
		});
		
		//dodanie listenera do paneluKontrolnego informujacego, ¿e user chce ponowic stare obstawienia z podwójn¹ stawk¹
		panelKontrolny.addRebet2xListener(new Rebet2xListener() {
			
			
			public void fireRebet2xEvent(Rebet2xEvent event) {
				int kwotaRebet = 0;
				boolean powyzejMaksimum = false;
				//ponowne obstawienie numerów 
				for (int i = 0; i < 37; i++){
					
					Numer rebetNumerow = panelObstawien.panelZNumeramiX.tablicaNumerow.get(i);
					int poprzedniaKwota = rebetNumerow.getPoprzedniaKwota()*2;
					if(poprzedniaKwota <=500){
						rebetNumerow.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetNumerow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowNumerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(i);
						rebetPrzyciskowNumerow.ustawKwoteRebet2x(poprzedniaKwota);
					}else{
						rebetNumerow.rebet2xKwotaZakladu(500);
						int kwotaObstawienia = rebetNumerow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowNumerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(i);
						rebetPrzyciskowNumerow.ustawKwoteRebet2x(500);
						powyzejMaksimum = true;
					}
				}
				
				//ponowne obstawienie splitów
				for(int i = 0; i < 60; i++){
					Split rebetSplitow = panelObstawien.panelZNumeramiX.tablicaSplitow.get(i);
					int poprzedniaKwota = rebetSplitow.getPoprzedniaKwota()*2;
					if(poprzedniaKwota <=500){
						rebetSplitow.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetSplitow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSplitow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSplitow.get(i);
						rebetPrzyciskowSplitow.ustawKwoteRebet2x(poprzedniaKwota);
					}else{
						rebetSplitow.rebet2xKwotaZakladu(500);
						int kwotaObstawienia = rebetSplitow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSplitow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSplitow.get(i);
						rebetPrzyciskowSplitow.ustawKwoteRebet2x(500);
						powyzejMaksimum = true;
					}
				}
				//ponowne obstawienie stritów
				for (int i = 0; i < 14; i++){
					Strit rebetStritow = panelObstawien.panelZNumeramiX.tablicaStritow.get(i);
					int poprzedniaKwota = rebetStritow.getPoprzedniaKwota()*2;
					if(poprzedniaKwota <=500){
						rebetStritow.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetStritow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowStritow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowStritow.get(i);
						rebetPrzyciskowStritow.ustawKwoteRebet2x(poprzedniaKwota);
					}else{
						rebetStritow.rebet2xKwotaZakladu(500);
						int kwotaObstawienia = rebetStritow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowStritow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowStritow.get(i);
						rebetPrzyciskowStritow.ustawKwoteRebet2x(500);
						powyzejMaksimum = true;
					}
				}
				// ponowne obstawienie kornerów
				for (int i = 0; i < 23; i++){
					Korner rebetKornerow = panelObstawien.panelZNumeramiX.tablicaKornerow.get(i);
					int poprzedniaKwota = rebetKornerow.getPoprzedniaKwota()*2;
					if (poprzedniaKwota <=500){
						rebetKornerow.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetKornerow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowKornerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKornerow.get(i);
						rebetPrzyciskowKornerow.ustawKwoteRebet2x(poprzedniaKwota);
					}else{
						rebetKornerow.rebet2xKwotaZakladu(500);
						int kwotaObstawienia = rebetKornerow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowKornerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKornerow.get(i);
						rebetPrzyciskowKornerow.ustawKwoteRebet2x(500);
						powyzejMaksimum= true;
					}
				}

				//ponowne obstawienie sixlinów
				for (int i = 0; i < 11; i++){
					SixLine rebetSixLinow = panelObstawien.panelZNumeramiX.tablicaSixLinow.get(i);
					int poprzedniaKwota = rebetSixLinow.getPoprzedniaKwota()*2;
					if(poprzedniaKwota<=500){			
						rebetSixLinow.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetSixLinow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSixLinow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSixLinow.get(i);
						rebetPrzyciskowSixLinow.ustawKwoteRebet2x(poprzedniaKwota);
					}else{
						rebetSixLinow.rebet2xKwotaZakladu(500);
						int kwotaObstawienia = rebetSixLinow.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSixLinow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSixLinow.get(i);
						rebetPrzyciskowSixLinow.ustawKwoteRebet2x(500);
						powyzejMaksimum = true;
					}
				}
				
				//ponowne obstawienie kolumn i tuzinów
				for (int i = 0; i < 6; i++){
					KolumnaITuzin rebetKIT = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(i);
					int poprzedniaKwota = rebetKIT.getPoprzedniaKwota()*2;
					if(poprzedniaKwota <=1500){
						rebetKIT.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetKIT.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowKIT = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKolumnITuzinow.get(i);
						rebetPrzyciskowKIT.ustawKwoteRebet2x(poprzedniaKwota);		
					}else{
						rebetKIT.rebet2xKwotaZakladu(1500);
						int kwotaObstawienia = rebetKIT.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowKIT = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKolumnITuzinow.get(i);
						rebetPrzyciskowKIT.ustawKwoteRebet2x(1500);
						powyzejMaksimum = true;
					}
				}
				
				// ponowne obstawienie szans prostych
				for (int i = 0; i <6; i++){
					SzansaProsta rebetSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(i);
					int poprzedniaKwota = rebetSzansy.getPoprzedniaKwota()*2;
					if(poprzedniaKwota<=1500){
						rebetSzansy.rebet2xKwotaZakladu(poprzedniaKwota);
						int kwotaObstawienia = rebetSzansy.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSzansy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(i);
						rebetPrzyciskowSzansy.ustawKwoteRebet2x(poprzedniaKwota);
					}if(poprzedniaKwota>1500){
						rebetSzansy.rebet2xKwotaZakladu(1500);
						int kwotaObstawienia = rebetSzansy.getKwotaZakladu();
						kwotaRebet = kwotaRebet + kwotaObstawienia;
						PrzyciskDlaRuletki rebetPrzyciskowSzansy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(i);
						rebetPrzyciskowSzansy.ustawKwoteRebet2x(1500);
						powyzejMaksimum =true;
					}
					
				}	
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				if(wartoscSalda < kwotaRebet){
					usuniecieStarychObstawien(false);
					panelKontrolny.getMiejsceNaTekst().appendKomunikatBrakSrodkow();
					
				}if(wartoscSalda>=kwotaRebet) {
					wartoscSalda = wartoscSalda - kwotaRebet;
					panelKontrolny.setWartoscSalda(wartoscSalda);
					panelKontrolny.refreshSaldo();
					wartoscObstawieniaNaRzut = kwotaRebet;
					if(powyzejMaksimum == true){
						panelKontrolny.getMiejsceNaTekst().appendZakladyDoMaksimum();
					}
				}
				
				panelKontrolny.disableRebet();
				panelKontrolny.disableRebet2x();
				panelKontrolny.enableStart();
				panelKontrolny.disableCofnij();
				panelKontrolny.enableWyczysc();
				
			}
		});
		
		
		//dodanie listenera do paneluKontrolnego informuj¹cego, ¿e user chce wyczyœciæ wszystkie swoje obstawienia
		panelKontrolny.addWyczyscKliknietoListener(new WyczyscKliknietoListener() {
			
			
			public void wyczyscKliknieto(WyczyscKliknietoEvent event) {
				
				usuniecieStarychObstawien(true);				
				int wartoscSalda = panelKontrolny.getWartoscSalda();
				wartoscSalda = wartoscSalda + wartoscObstawieniaNaRzut;
				wartoscObstawieniaNaRzut = 0;
				panelKontrolny.setWartoscSalda(wartoscSalda);
				panelKontrolny.refreshSaldo();
				panelKontrolny.disableWyczysc();
				panelKontrolny.disableCofnij();
			
			}
		});
		
		
		
		
		// dodanie listenera do paneluKontrolnego informujacego o zmianiezmieniono stawki obstawiania
		panelKontrolny.addZmianaStawkiListener(new ZmianaStawkiListener(){
			
			public void zmianaStawkiOccured(ZmianaStawkiEvent event){
				int wartoscStawki = event.getWartoscStawki();
				PrzyciskDlaRuletki nowy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(6);
				nowy.ustawIkone(wartoscStawki);
				panelObstawien.panelZNumeramiX.setWartoscJednegoZetonu(wartoscStawki);
				
			}
		});
		
		//dodanie listenera do panelu kontrolnego, by by³o wiadomo, gdy user kliknie start
		panelKontrolny.addStartListener(new StartListener(){
			
			public void startKliknieto(StartKliknietoEvent event){
				kwotaCalkowitejWygranej = 0;
				metodaLosujaca();
				sprawdzenieObstawien(wygranyNumer);
				wyplataWygranej(kwotaCalkowitejWygranej);	
				wyswietlWygranyNumer(wygranyNumer);
				podswietlWygranyNumer(wygranyNumer);
			
				if (kwotaCalkowitejWygranej > wartoscObstawieniaNaRzut){				
					panelKontrolny.getMiejsceNaTekst().appendKomunikatOWygranej(kwotaCalkowitejWygranej);
					}
				
				if ((kwotaCalkowitejWygranej < wartoscObstawieniaNaRzut) && (wartoscObstawieniaNaRzut > 0 ) && (kwotaCalkowitejWygranej > 0)){
					panelKontrolny.getMiejsceNaTekst().appendKomunikatOZwrotach(kwotaCalkowitejWygranej);
				}	
				
				if (kwotaCalkowitejWygranej == 0){
					if(wartoscObstawieniaNaRzut == 0){
						panelKontrolny.getMiejsceNaTekst().appendBrakObstawien();
						
					}else{	
			
						panelKontrolny.getMiejsceNaTekst().appendKomunikatOPorazce();
					}
				}
				panelKontrolny.disableStart();
				panelKontrolny.disableWyczysc();
				panelKontrolny.disableCofnij();
				panelKontrolny.enableNoweObstawienia();
				panelKontrolny.disableRebet();
				panelKontrolny.disableRebet2x();
				flagaBlokadyObstawien = true;
				
				//usuniecieStarychObstawien();
				
				
				
				
				
			}
			
		});
		
		//dodanie opcji automatycznego wczytywania gry przy uruchomieniu
		
		SaveGame save = new SaveGame();
		save.wczytajGre();
		int wczytanaWartoscSalda = save.getWartoscSaldaDoOdczytu();
		panelKontrolny.setWartoscSalda(wczytanaWartoscSalda);
		panelKontrolny.refreshSaldo();
		if (wczytanaWartoscSalda != 0){
	
			panelKontrolny.nowaGra();
		}
		
		
		// dodanie komponentów do ramki
		Container cont = getContentPane();
		cont.add(panelObstawien, BorderLayout.CENTER);
		cont.add(panelKontrolny, BorderLayout.SOUTH);
		
		// dodanie menu
		JMenuBar pasekMenu = new JMenuBar();
		JMenu menuPlik = new JMenu("Plik");
		JMenuItem nowaGra = new JMenuItem("Nowa gra");
		nowaGra.addActionListener(new NowaGraActionListener());
		menuPlik.add(nowaGra);
		pasekMenu.add(menuPlik);		
		setJMenuBar(pasekMenu);		
		pack();

	}
	
	public int metodaLosujaca(){
		wygranyNumer = 0;
		wygranyNumer = (int)(Math.random() * 37);
		return wygranyNumer;
		
	}
	
	public int sprawdzenieObstawien(int wygranyNumer){
		
		//sprawdzenie numerów
		Numer szczesliwyNumer = panelObstawien.panelZNumeramiX.tablicaNumerow.get(wygranyNumer);
		kwotaCalkowitejWygranej = szczesliwyNumer.getKwotaZakladu()*36;
		
		//sprawdzenie splitów
		for(int i = 0; i < 60; i++){
			Split sprawdzSplit = panelObstawien.panelZNumeramiX.tablicaSplitow.get(i);
			if (sprawdzSplit.getNumer1() == wygranyNumer){
				int kwotaWygranejSplitow = sprawdzSplit.getKwotaZakladu()*18;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSplitow;
			}
			if (sprawdzSplit.getNumer2() == wygranyNumer){
				int kwotaWygranejSplitow = sprawdzSplit.getKwotaZakladu()*18;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSplitow;
			}
			
			
		}
		
		// sprawdzenie stritow
		
		for (int i = 0; i < 14; i++){
			Strit sprawdzStrit = panelObstawien.panelZNumeramiX.tablicaStritow.get(i);
			if (sprawdzStrit.getNumer1() == wygranyNumer){
				int kwotaWygranejStritow = sprawdzStrit.getKwotaZakladu()*12;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejStritow;
			}
			if (sprawdzStrit.getNumer2() == wygranyNumer){
				int kwotaWygranejStritow = sprawdzStrit.getKwotaZakladu()*12;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejStritow;
			}
			if (sprawdzStrit.getNumer3() == wygranyNumer){
				int kwotaWygranejStritow = sprawdzStrit.getKwotaZakladu()*12;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejStritow;
			}
		}
		
		//sprawdzenie kornerow
		
		for (int i = 0; i < 23; i++){
			Korner sprawdzKorner = panelObstawien.panelZNumeramiX.tablicaKornerow.get(i);
			if (sprawdzKorner.getNumer1() == wygranyNumer){
				int kwotaWygranejKornerow = sprawdzKorner.getKwotaZakladu()*9;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKornerow;
			}
			if (sprawdzKorner.getNumer2() == wygranyNumer){
				int kwotaWygranejKornerow = sprawdzKorner.getKwotaZakladu()*9;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKornerow;
			}
			if (sprawdzKorner.getNumer3() == wygranyNumer){
				int kwotaWygranejKornerow = sprawdzKorner.getKwotaZakladu()*9;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKornerow;
			}
			if (sprawdzKorner.getNumer4() == wygranyNumer){
				int kwotaWygranejKornerow = sprawdzKorner.getKwotaZakladu()*9;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKornerow;
			}
		}
		
		//sprawdzenie sixlinów
		for (int i = 0; i < 11; i++){
			SixLine sprawdzSixLine = panelObstawien.panelZNumeramiX.tablicaSixLinow.get(i);
			if (sprawdzSixLine.getNumer1() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
			if (sprawdzSixLine.getNumer2() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
			if (sprawdzSixLine.getNumer3() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
			if (sprawdzSixLine.getNumer4() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
			if (sprawdzSixLine.getNumer5() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
			if (sprawdzSixLine.getNumer6() == wygranyNumer){
				int kwotaWygranejSixLinow = sprawdzSixLine.getKwotaZakladu()*6;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSixLinow;
			}
		}
		
		//sprawdzenie kolumn 
		
		
		
		for (int i = 0; i < 12; i++){
			if(wygranyNumer == trzeciaKolumna[i]){
				int kwotaWygranejKolumn = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(0).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKolumn; 
			}
			if(wygranyNumer == drugaKolumna[i]){
				int kwotaWygranejKolumn = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(1).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKolumn; 
			}
			if(wygranyNumer == pierwszaKolumna[i]){
				int kwotaWygranejKolumn = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(2).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejKolumn; 
			}
			if(wygranyNumer == pierwszyTuzin[i]){
				int kwotaWygranejTuzinow = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(3).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejTuzinow; 
			}
			if(wygranyNumer == drugiTuzin[i]){
				int kwotaWygranejTuzinow = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(4).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejTuzinow; 
			}
			if(wygranyNumer == trzeciTuzin[i]){
				int kwotaWygranejTuzinow = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(5).getKwotaZakladu()*3;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejTuzinow; 
			}
		}
		// sprawdzenie szans prostych
		
		
		for (int i = 0; i < 18; i++){
			if (wygranyNumer == niskie[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(0).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
			if (wygranyNumer == parzyste[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(1).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
			if (wygranyNumer == czerwone[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(2).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
			if (wygranyNumer == czarne[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(3).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
			if (wygranyNumer == nieparzyste[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(4).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
			if (wygranyNumer == wysokie[i]){
				int kwotaWygranejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(5).getKwotaZakladu()*2;
				kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaWygranejSzansy;
			}
					
		}
		if (wygranyNumer == 0){
			int i;
			for (i = 0; i < 6; i++){
			int kwotaZachowanejSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(i).getKwotaZakladu()/2;
			kwotaCalkowitejWygranej = kwotaCalkowitejWygranej + kwotaZachowanejSzansy;
			}
		}
		
			
		
		return kwotaCalkowitejWygranej;
	
		
	}
	
	public void wyplataWygranej(int kwotaCalkowitejWygranej){
		int wartoscSalda = panelKontrolny.getWartoscSalda();
		wartoscSalda = wartoscSalda + kwotaCalkowitejWygranej;
		panelKontrolny.setWartoscSalda(wartoscSalda);
		panelKontrolny.refreshSaldo();
		
	}

	class NowaGraActionListener implements ActionListener{


		public void actionPerformed(ActionEvent e) {
	
			flagaBlokadyObstawien = false;
			panelKontrolny.setWartoscSalda(1000);
			panelKontrolny.refreshSaldo();
			usuniecieStarychObstawien(true);
			panelKontrolny.getMiejsceNaTekst().appendNowaGra();
			panelKontrolny.nowaGra();
			
		}
	}
	
	public void usuniecieStarychObstawien(boolean zerowanie){
		
		//usuniecie obstawieñ z numerów 
		for (int i = 0; i < 37; i++){
			
			Numer usunZNumerow = panelObstawien.panelZNumeramiX.tablicaNumerow.get(i);
			usunZNumerow.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowNumerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(i);
			usunZPrzyciskowNumerow.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZNumerow.zerujPoprzedniaKwote();
				usunZPrzyciskowNumerow.zerujWartoscPoprzedniejKwoty();
			}
		}
		
		//usuniêcie obstawieñ ze splitów
		for(int i = 0; i < 60; i++){
			Split usunZeSplitow = panelObstawien.panelZNumeramiX.tablicaSplitow.get(i);
			usunZeSplitow.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowSplitow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSplitow.get(i);
			usunZPrzyciskowSplitow.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZeSplitow.zerujPoprzedniaKwote();
				usunZPrzyciskowSplitow.zerujWartoscPoprzedniejKwoty();
			}
		}
		//usuniêcie obstawieñ ze stritów
		for (int i = 0; i < 14; i++){
			Strit usunZeStritow = panelObstawien.panelZNumeramiX.tablicaStritow.get(i);
			usunZeStritow.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowStritow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowStritow.get(i);
			usunZPrzyciskowStritow.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZeStritow.zerujPoprzedniaKwote();
				usunZPrzyciskowStritow.zerujWartoscPoprzedniejKwoty();
			}
		}
		// usuniêcie obstawieñ z kornerów
		for (int i = 0; i < 23; i++){
			Korner usunZKornerow = panelObstawien.panelZNumeramiX.tablicaKornerow.get(i);
			usunZKornerow.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowKornerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKornerow.get(i);
			usunZPrzyciskowKornerow.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZKornerow.zerujPoprzedniaKwote();
				usunZPrzyciskowKornerow.zerujWartoscPoprzedniejKwoty();
			}
			
		}

		// usuniêcie obstawieñ z sixlinów
		for (int i = 0; i < 11; i++){
			SixLine usunZSixLinow = panelObstawien.panelZNumeramiX.tablicaSixLinow.get(i);
			usunZSixLinow.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowSixLinow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSixLinow.get(i);
			usunZPrzyciskowSixLinow.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZSixLinow.zerujPoprzedniaKwote();
				usunZPrzyciskowSixLinow.zerujWartoscPoprzedniejKwoty();
			}
		}
		
		//usuniêcie obstawieñ z kolumn i tuzinów
		for (int i = 0; i < 6; i++){
			KolumnaITuzin usunZKIT = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(i);
			usunZKIT.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowKIT = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKolumnITuzinow.get(i);
			usunZPrzyciskowKIT.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZKIT.zerujPoprzedniaKwote();
				usunZPrzyciskowKIT.zerujWartoscPoprzedniejKwoty();
			}
			
		}
		
		// usuniêcie obstawieñ z szans prostych
		for (int i = 0; i <6; i++){
			SzansaProsta usunZSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(i);
			usunZSzansy.setKwotaZakladu(0);
			PrzyciskDlaRuletki usunZPrzyciskowSzansy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(i);
			usunZPrzyciskowSzansy.zerujWartoscZetonu();
			if (zerowanie == true){
				usunZSzansy.zerujPoprzedniaKwote();
				usunZPrzyciskowSzansy.zerujWartoscPoprzedniejKwoty();
			}
			
		}	
			
	}
	
	public void wyswietlWygranyNumer(int wygranyNumer){
		for (int i = 0; i<18; i++){
			if (wygranyNumer == czerwone[i]){
				StyleConstants.setForeground(panelObstawien.style1, Color.RED);
				try {
					panelObstawien.doc.insertString(panelObstawien.doc.getLength(), Integer.toString(wygranyNumer)+"\n", panelObstawien.style1);
				} catch (BadLocationException e) {
					System.err.println("To jaki by³ ostatni numer?");
				}
				
			}
			if (wygranyNumer == czarne[i]){
				StyleConstants.setForeground(panelObstawien.style2, Color.BLACK);
				try {
					panelObstawien.doc.insertString(panelObstawien.doc.getLength(), Integer.toString(wygranyNumer)+"\n", panelObstawien.style2);
				} catch (BadLocationException e) {
					System.err.println("To jaki by³ ostatni numer?");
				}
			}
		}	
		if (wygranyNumer == 0){
			StyleConstants.setForeground(panelObstawien.style3, Color.GREEN);
			try {
				panelObstawien.doc.insertString(panelObstawien.doc.getLength(), Integer.toString(wygranyNumer)+"\n", panelObstawien.style3);
			} catch (BadLocationException e) {
				System.err.println("To jaki by³ ostatni numer?");
			}
		}
			
	}
	

	public void podswietlWygranyNumer(int numer) {
		
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		   
		    
				PrzyciskDlaRuletki wygrany = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(numer);
		    	wygrany.podswietlicNumer();
		    }
		});
	}
	
	public void zerujPoprzedniaKwota(){
		//usuniecie poprzednich obstawieñ z numerów 
		for (int i = 0; i < 37; i++){
			
			Numer usunZNumerow = panelObstawien.panelZNumeramiX.tablicaNumerow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowNumerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowNumerow.get(i);
			if(usunZNumerow.getKwotaZakladu() != usunZNumerow.getPoprzedniaKwota()){
				usunZNumerow.zerujPoprzedniaKwote();
				usunZPrzyciskowNumerow.zerujWartoscPoprzedniejKwoty();
			}

			
		}
		
		//usuniêcie poprzednich obstawieñ ze splitów
		for(int i = 0; i < 60; i++){
			Split usunZeSplitow = panelObstawien.panelZNumeramiX.tablicaSplitow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowSplitow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSplitow.get(i);
			if(usunZeSplitow.getKwotaZakladu() != usunZeSplitow.getPoprzedniaKwota()){
				usunZeSplitow.zerujPoprzedniaKwote();
				usunZPrzyciskowSplitow.zerujWartoscPoprzedniejKwoty();
				
			}

		}
		//usuniêcie poprzednich obstawieñ ze stritów
		for (int i = 0; i < 14; i++){
			Strit usunZeStritow = panelObstawien.panelZNumeramiX.tablicaStritow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowStritow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowStritow.get(i);
			if(usunZeStritow.getKwotaZakladu() != usunZeStritow.getPoprzedniaKwota()){
				usunZeStritow.zerujPoprzedniaKwote();
				usunZPrzyciskowStritow.zerujWartoscPoprzedniejKwoty();
				
			}
			
		}
		// usuniêcie poprzednich obstawieñ z kornerów
		for (int i = 0; i < 23; i++){
			Korner usunZKornerow = panelObstawien.panelZNumeramiX.tablicaKornerow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowKornerow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKornerow.get(i);
			if(usunZKornerow.getKwotaZakladu() != usunZKornerow.getPoprzedniaKwota()){
				usunZKornerow.zerujPoprzedniaKwote();
				usunZPrzyciskowKornerow.zerujWartoscPoprzedniejKwoty();
			}

	
		}

		// usuniêcie poprzednich obstawieñ z sixlinów
		for (int i = 0; i < 11; i++){
			SixLine usunZSixLinow = panelObstawien.panelZNumeramiX.tablicaSixLinow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowSixLinow = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSixLinow.get(i);
			if(usunZSixLinow.getKwotaZakladu() != usunZSixLinow.getPoprzedniaKwota()){
				usunZSixLinow.zerujPoprzedniaKwote();
				usunZPrzyciskowSixLinow.zerujWartoscPoprzedniejKwoty();
			}
	
			
		}
		
		//usuniêcie obstawieñ z kolumn i tuzinów
		for (int i = 0; i < 6; i++){
			KolumnaITuzin usunZKIT = panelObstawien.panelZNumeramiX.tablicaKolumnITuzinow.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowKIT = panelObstawien.panelZNumeramiX.tablicaPrzyciskowKolumnITuzinow.get(i);	
			if(usunZKIT.getKwotaZakladu() != usunZKIT.getPoprzedniaKwota()){
				usunZKIT.zerujPoprzedniaKwote();
				usunZPrzyciskowKIT.zerujWartoscPoprzedniejKwoty();
			}
		
			
			
		}
		
		// usuniêcie obstawieñ z szans prostych
		for (int i = 0; i <6; i++){
			SzansaProsta usunZSzansy = panelObstawien.panelZNumeramiX.tablicaSzansProstych.get(i);
			PrzyciskDlaRuletki usunZPrzyciskowSzansy = panelObstawien.panelZNumeramiX.tablicaPrzyciskowSzansProstych.get(i);
			if(usunZSzansy.getKwotaZakladu() != usunZSzansy.getPoprzedniaKwota()){
				usunZSzansy.zerujPoprzedniaKwote();
				usunZPrzyciskowSzansy.zerujWartoscPoprzedniejKwoty();
			}


			
		}	
	
	}
}
