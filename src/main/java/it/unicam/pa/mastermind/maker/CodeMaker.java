package it.unicam.pa.mastermind.maker;

import it.unicam.pa.mastermind.ColorStack;

/**
 * 
 */

/**
 * Responsabilità: Creare il codice da decifrare
 * 
 * @author joel
 *
 */

public interface CodeMaker {
	/**
	 * Genera il codice da decifrare
	 * 
	 * @return ColorStack con dentro i colori
	 */
	public ColorStack generateCode();
}
