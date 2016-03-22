package com.blinddealercasino;

import java.util.EventObject;

/** 
 * 
 * Troch� bardziej skomplikowane rozszerzenie klasy EventObject. Tym razem obiekt zdarzenia
 * musi przekaza� tak�e informacje o zak�adzie obstawionym i o przycisku klikni�tym przez gracza.
 * St�d konieczne s� gettery dla tych obiekt�w.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public class DokonanoObstawieniaEvent extends EventObject {


	private static final long serialVersionUID = 7781676245049843389L;
	private int wartoscObstawienia;
	private Zaklad zaklad;
	private PrzyciskDlaRuletki przycisk;
	
	public DokonanoObstawieniaEvent(Object source, int wartoscObstawienia, Zaklad zaklad, PrzyciskDlaRuletki przyciskDlaRuletki) {
		super(source);
		this.wartoscObstawienia = wartoscObstawienia;
		this.zaklad = zaklad;
		this.przycisk = przyciskDlaRuletki;
	}
	
	public int getWartoscObstawienia(){
		return wartoscObstawienia;
	}
	
	public Zaklad getZaklad(){
		return zaklad;
	}
	
	public PrzyciskDlaRuletki getPrzycisk(){
		return przycisk;
	}
	
}
