package com.blinddealercasino;

import java.util.EventListener;

/** 
 * Interfejs zdarzenia generowanego, gdy gracz kliknie kt�ry� z przycisk�w odpowiadajacych za 
 * zmian� stawki. 
 * 
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface ZmianaStawkiListener extends EventListener {

	public void zmianaStawkiOccured(ZmianaStawkiEvent event);
}
