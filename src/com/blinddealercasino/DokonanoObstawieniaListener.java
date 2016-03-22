package com.blinddealercasino;

import java.util.EventListener;


/** 
 * 
 * Zwyk³e rozszerzenie interfejsu EventListener odpowiadaj¹ce za generowanie zdarzeñ 
 * zwi¹zanych z dokonywaniem obstawieñ na planszy paneluZNumeramiX.
 * 
 * 
 * 
 * @author Piotr Baczyñski-Kaczmarek
 * 
 */


public interface DokonanoObstawieniaListener extends EventListener {

	public void dokonanoObstawienia(DokonanoObstawieniaEvent event);
}
