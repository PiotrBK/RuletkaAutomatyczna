package com.blinddealercasino;

import java.util.EventListener;


/** 
 * Interfejs odpowiadaj�cy za reakcj� na klikni�cie przycisku cofnij w paneluKontrolnym.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */

public interface CofnijKliknietoListener extends EventListener {

	public void cofnijKliknieto(CofnijKliknietoEvent event);
	
}
