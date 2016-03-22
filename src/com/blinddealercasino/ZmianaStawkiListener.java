package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs zdarzenia generowanego, gdy gracz kliknie któryœ z przycisków odpowiadajacych za 
 * zmianê stawki. 
 * 
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface ZmianaStawkiListener extends EventListener {

	public void zmianaStawkiOccured(ZmianaStawkiEvent event);
}
