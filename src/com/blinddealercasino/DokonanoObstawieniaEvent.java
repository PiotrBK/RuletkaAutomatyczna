package com.blinddealercasino;

import java.util.EventObject;

/** 
 * 
 * Trochê bardziej skomplikowane rozszerzenie klasy EventObject. Tym razem obiekt zdarzenia
 * musi przekazaæ tak¿e informacje o zak³adzie obstawionym i o przycisku klikniêtym przez gracza.
 * St¹d konieczne s¹ gettery dla tych obiektów.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
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
