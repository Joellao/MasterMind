package it.unicam.pa.mastermind.view;

import java.util.List;

import it.unicam.pa.mastermind.ColorStack;
import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.endgame.WinCouple;
import it.unicam.pa.mastermind.enums.CheckResult;
import it.unicam.pa.mastermind.enums.Colors;

/**
 * Responsabilità: Definire i metodi base per creare una view
 * Ha il compito di comunicare con l'utente per input e output
 * 
 * @author joel
 *
 */
public interface View {
	/**
	 * @return un Enum di Colors che individua il colore scelto dall'utente
	 */
	public Colors getColor();

	/**
	 * Stampa la tavola dei colori
	 */
	public void printBoard();
	
	/**
	 * Stampa il codice da decifrare
	 * @param code codice da stampare
	 */
	public void printCode(ColorStack code);


	/**
	 * Stampa i pegs calcolati in base al tentativo fatto dall'utente
	 * 
	 * @param pegs stampa la lista di pegs
	 */
	public void printPegs(List<CheckResult> pegs);
	
	/**
	 * Stampa il vincitore se esiste.
	 * @param couple stampa il vincitore
	 */
	public void printWinner(WinCouple couple);

	/**
	 * Metodo di default per avere un Enum indicizzato
	 * 
	 * @param x posizione del colore
	 * @return Enum di Colors
	 */
	default Colors indexedEnum(int x) {
		return Colors.values()[x];
	}
	
	/**
	 * Stampa il nome del giocatore il quale ha il turno di gioco
	 * @param breaker per ricevere il nome da stampare
	 */
	public void printTurnRound(CodeBreaker breaker);
	

}
