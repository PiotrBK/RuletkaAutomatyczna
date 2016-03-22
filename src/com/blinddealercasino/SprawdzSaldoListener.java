package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs odpowiadajacy za wygenerowanie obiektu zdarzenia, gdy gracz dokonuje obstawienia na planszy i aplikacja 
 * musi sprawdzi�, czy obstawienie jest poprawne pod k�tem obstawionej kwoty.
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface SprawdzSaldoListener extends EventListener {

	public void sprawdzSaldo(SprawdzSaldoEvent event);
	
}
