package it.unicam.pa.mastermind.endgame;

import it.unicam.pa.mastermind.Couple;

/**
 * Responsabilità: Avere la coppia che vince la partita
 * @author joel
 *
 */
public class WinCouple {
	private Couple couple;

	public WinCouple(Couple couple) {
		this.couple = couple;
	}
	
	public Couple getCouple() {
		return this.couple;
	}
	
	public String getWinner() {
		if(this.couple!=null) {
			return couple.getBreaker().getName();
		}
		return null;
	}
}
