package com.blinddealercasino;

import java.util.EventListener;


/** 
 * Interfejs odpowiadaj¹cy za reakcjê na klikniêcie przycisku cofnij w paneluKontrolnym.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */

public interface CofnijKliknietoListener extends EventListener {

	public void cofnijKliknieto(CofnijKliknietoEvent event);
	
}
