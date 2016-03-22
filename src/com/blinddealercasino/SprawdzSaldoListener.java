package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadajacy za wygenerowanie obiektu zdarzenia, gdy gracz dokonuje obstawienia na planszy i aplikacja 
 * musi sprawdziæ, czy obstawienie jest poprawne pod k¹tem obstawionej kwoty.
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface SprawdzSaldoListener extends EventListener {

	public void sprawdzSaldo(SprawdzSaldoEvent event);
	
}
