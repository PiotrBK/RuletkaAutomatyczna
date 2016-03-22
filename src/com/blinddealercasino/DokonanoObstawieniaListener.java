package com.blinddealercasino;

import java.util.EventListener;


/** 
 * 
 * Zwyk�e rozszerzenie interfejsu EventListener odpowiadaj�ce za generowanie zdarze� 
 * zwi�zanych z dokonywaniem obstawie� na planszy paneluZNumeramiX.
 * 
 * 
 * 
 * @author Piotr Baczy�ski-Kaczmarek
 * 
 */


public interface DokonanoObstawieniaListener extends EventListener {

	public void dokonanoObstawienia(DokonanoObstawieniaEvent event);
}
