package it.unicam.pa.mastermind.breaker;


import it.unicam.pa.mastermind.ColorStack;

/**
 * Responsabilità: Decifrare il codice creato
 * 
 * @author joel
 *
 */
public interface CodeBreaker {
	/**
	 * Il CodeBreaker fa un tentativo per indovinare il codice
	 * 
	 * @return ColorStack del tentativo
	 */
	public ColorStack makeAttempt();

	/**
	 * @return nome CodeBreaker
	 */
	public String getName();

	/**
	 * @return numero tentativi
	 */
	public int getAttempts();

}
