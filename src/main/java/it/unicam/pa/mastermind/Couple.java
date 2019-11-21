package it.unicam.pa.mastermind;

import it.unicam.pa.mastermind.breaker.CodeBreaker;

/**
 * Responsabilità: Contenere sia il giocatore che decodifica sia la tavola da
 * decodifiare
 * 
 * @author joel
 *
 */
public class Couple {
	private CodeBreaker breaker;
	private Board board;

	public Couple(CodeBreaker breaker, Board board) {
		this.breaker = breaker;
		this.board = board;
	}

	public CodeBreaker getBreaker() {
		return this.breaker;
	}

	public Board getBoard() {
		return this.board;
	}
}
